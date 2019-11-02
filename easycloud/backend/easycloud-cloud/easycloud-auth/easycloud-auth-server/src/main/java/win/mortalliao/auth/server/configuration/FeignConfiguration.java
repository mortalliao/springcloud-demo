package win.mortalliao.auth.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import win.mortalliao.auth.server.interceptor.ClientTokenInterceptor;

/**
 * @author mortal
 * feign 服务对服务拦截鉴权
 */
@Configuration
public class FeignConfiguration {

    @Bean
    ClientTokenInterceptor getClientTokenInterceptor() {
        return new ClientTokenInterceptor();
    }
}
