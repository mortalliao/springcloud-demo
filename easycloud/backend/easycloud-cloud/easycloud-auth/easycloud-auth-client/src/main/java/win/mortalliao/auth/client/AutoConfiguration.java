package win.mortalliao.auth.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import win.mortalliao.auth.client.config.ServiceAuthConfig;
import win.mortalliao.auth.client.config.UserAuthConfig;

/**
 * @author mortal
 */
@Configuration
@ComponentScan("win.mortalliao.auth.client")
public class AutoConfiguration {
    @Bean
    ServiceAuthConfig getServiceAuthConfig() {
        return new ServiceAuthConfig();
    }

    @Bean
    UserAuthConfig getUserAuthConfig() {
        return new UserAuthConfig();
    }
}
