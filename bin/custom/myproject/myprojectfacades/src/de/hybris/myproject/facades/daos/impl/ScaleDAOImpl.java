package de.hybris.myproject.facades.daos.impl;

import de.hybris.myproject.core.model.ApparelProductModel;
import de.hybris.myproject.facades.daos.ScaleDAO;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.List;

public class ScaleDAOImpl implements ScaleDAO {

    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<ApparelProductModel> findAllWithScale() {
        final String queryString =
                "SELECT {p:" + ApparelProductModel.PK + "} "
                        + "FROM {" + ApparelProductModel._TYPECODE + " AS p} WHERE {" + ApparelProductModel.SCALE + "} IS NOT NULL";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        return flexibleSearchService.<ApparelProductModel>search(query).getResult();
    }

    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
}
