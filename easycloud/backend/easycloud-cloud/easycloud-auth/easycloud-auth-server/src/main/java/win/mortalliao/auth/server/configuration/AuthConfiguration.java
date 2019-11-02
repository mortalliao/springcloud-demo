package win.mortalliao.auth.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import win.mortalliao.starter.common.handler.GlobalExceptionHandler;

/**
 * @author mortal
 * 全局异常处理
 */
@Configuration
public class AuthConfiguration {

    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
