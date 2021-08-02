package de.hybris.myproject.facades.interceptors;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;

import java.util.Locale;

public class UserPrepareDefaultInterceptor implements PrepareInterceptor<CustomerModel> {
//    final Map<String, Object> disableByType = ImmutableMap.of(InterceptorExecutionPolicy.DISABLED_INTERCEPTOR_BEANS, ImmutableSet.of(InterceptorExecutionPolicy.InterceptorType.REMOVE));
//    final Map<String, Object> disableDirectly = ImmutableMap.of(InterceptorExecutionPolicy.DISABLED_INTERCEPTOR_BEANS, ImmutableSet.of("UserPrepareDefaultInterceptor"));

    @Override
    public void onPrepare(CustomerModel customerModel, InterceptorContext interceptorContext) throws InterceptorException {
        customerModel.setDescription(customerModel.getDescription().toUpperCase(Locale.getDefault()));
    }

//    private void disableDirectInterceptor() {
//        sessionService.executeInLocalViewWithParams(disableDirectly, new SessionExecutionBody(){
//            @Override
//            public void executeWithoutResult()
//            {
//                System.out.println("skip intercptor");
//            }
//        });
//    }
//
//    private void disableByTypeDirectInterceptor() {
//        sessionService.executeInLocalViewWithParams(disableDirectly, new SessionExecutionBody(){
//            @Override
//            public void executeWithoutResult()
//            {
//                System.out.println("skip intercptor");
//            }
//        });
//    }
}
