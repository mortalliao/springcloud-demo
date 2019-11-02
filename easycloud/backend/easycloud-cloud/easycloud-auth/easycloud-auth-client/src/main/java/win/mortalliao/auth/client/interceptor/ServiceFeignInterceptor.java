package win.mortalliao.auth.client.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import win.mortalliao.auth.client.config.ServiceAuthConfig;
import win.mortalliao.auth.client.config.UserAuthConfig;
import win.mortalliao.auth.client.context.UserContext;
import win.mortalliao.auth.client.helper.ServiceAuthHelper;

/**
 * @author mortal
 */
public class ServiceFeignInterceptor implements RequestInterceptor {

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;

    @Autowired
    private UserAuthConfig userAuthConfig;

    @Autowired
    private ServiceAuthHelper serviceAuthHelper;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(serviceAuthConfig.getTokenHeader(), serviceAuthHelper.getClientToken());
        requestTemplate.header(userAuthConfig.getTokenHeader(), UserContext.getToken());
    }
}