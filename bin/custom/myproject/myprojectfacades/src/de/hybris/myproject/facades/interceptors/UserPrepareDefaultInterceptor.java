package de.hybris.myproject.facades.interceptors;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;

import java.util.Locale;

public class UserPrepareDefaultInterceptor implements PrepareInterceptor<CustomerModel> {
    @Override
    public void onPrepare(CustomerModel customerModel, InterceptorContext interceptorContext) throws InterceptorException {
        customerModel.setDescription(customerModel.getDescription().toUpperCase(Locale.getDefault()));
    }
}
