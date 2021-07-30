package de.hybris.myproject.facades.interceptors;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.LoadInterceptor;

public class UserLoadDefaultInterceptor implements LoadInterceptor<CustomerModel> {

    @Override
    public void onLoad(CustomerModel customerModel, InterceptorContext interceptorContext) throws InterceptorException {
        customerModel.setName("UserLoadDefaultInterceptor");
    }
}
