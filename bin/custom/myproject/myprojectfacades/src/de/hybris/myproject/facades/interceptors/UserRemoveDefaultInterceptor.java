package de.hybris.myproject.facades.interceptors;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.LoadInterceptor;
import de.hybris.platform.servicelayer.interceptor.RemoveInterceptor;
import org.apache.log4j.Logger;

public class UserRemoveDefaultInterceptor implements RemoveInterceptor<CustomerModel> {
    private static final Logger LOGGER = Logger.getLogger(UserRemoveDefaultInterceptor.class);

    @Override
    public void onRemove(CustomerModel customerModel, InterceptorContext interceptorContext) throws InterceptorException {
        LOGGER.info("++++UserRemoveDefaultInterceptor+++" + customerModel);
    }
}
