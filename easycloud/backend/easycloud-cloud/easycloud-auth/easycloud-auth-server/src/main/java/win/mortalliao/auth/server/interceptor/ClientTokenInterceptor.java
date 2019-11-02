package win.mortalliao.auth.server.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import win.mortalliao.auth.server.configuration.ClientConfig;
import win.mortalliao.auth.server.service.ClientService;

/**
 * @author mortal
 * feign 拦截器
 * header中加入客户端token
 */
public class ClientTokenInterceptor implements RequestInterceptor {
    @Autowired
    private ClientConfig clientConfig;

    @Autowired
    private ClientService clientService;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        try {
            requestTemplate.header(clientConfig.getClientTokenHeader(), clientService.apply(clientConfig.getClientId(), clientConfig.getClientSecret()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
