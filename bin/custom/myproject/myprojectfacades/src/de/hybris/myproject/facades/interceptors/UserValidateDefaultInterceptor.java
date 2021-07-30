package de.hybris.myproject.facades.interceptors;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;
import org.apache.log4j.Logger;

public class UserValidateDefaultInterceptor implements ValidateInterceptor<CustomerModel> {
    private static final Logger LOGGER = Logger.getLogger(UserValidateDefaultInterceptor.class);

    @Override
    public void onValidate(CustomerModel customerModel, InterceptorContext interceptorContext) throws InterceptorException {
        LOGGER.info("++++UserValidateDefaultInterceptor+++" + customerModel.getDescription());
    }
}
