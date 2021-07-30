package de.hybris.myproject.facades.interceptors;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.interceptor.InitDefaultsInterceptor;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import org.apache.solr.common.StringUtils;

public class UserInitDefaultInterceptor implements InitDefaultsInterceptor {

    @Override
    public void onInitDefaults(Object model, InterceptorContext interceptorContext) throws InterceptorException {
        if (model instanceof CustomerModel) {
            final CustomerModel customerModel = (CustomerModel) model;
            if (interceptorContext.isNew(model)) {
                if (StringUtils.isEmpty(customerModel.getDescription())){
                    customerModel.setDescription("UserDefaultInterceptor");
                }
            }
        }
    }
}
