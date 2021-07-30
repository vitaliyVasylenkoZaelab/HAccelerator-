package de.hybris.myproject.core.job;

import de.hybris.myproject.core.model.ApparelProductModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.util.Config;
import org.apache.log4j.Logger;

import java.io.ObjectInputFilter;
import java.util.List;


public class ScaleAbortableJob extends AbstractJobPerformable<CronJobModel> {
    private static final Logger LOG = Logger.getLogger(ScaleAbortableJob.class);

    private FlexibleSearchService flexibleSearchService;

    @Override
    public PerformResult perform(CronJobModel cronJobModel) {
        final String queryString =
                "SELECT {p:" + ApparelProductModel.PK + "} "
                        + "FROM {" + ApparelProductModel._TYPECODE + " AS p} WHERE {" + ApparelProductModel.SCALE + "} IS NOT NULL";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

        List<ApparelProductModel> productModels = flexibleSearchService.<ApparelProductModel>search(query).getResult();
        for (ApparelProductModel productModel : productModels) {
            if(clearAbortRequestedIfNeeded(cronJobModel)){
                LOG.info("+++ Job was aborted +++");
                return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.ABORTED);
            }
            try {
                String delay = Config.getString("scaleCronJob.delay", "5000");
                LOG.info("+++ Job delay +++ " + delay);
                Thread.sleep(Long.parseLong(delay));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LOG.info("+++ScaleAbortableJob:" + productModel.getName() + productModel.getScale() + "+++");
        }
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    @Override
    public boolean isAbortable() {
        return true;
    }

    @Override
    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
}
