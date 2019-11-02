package com.easycloud.urule.config;

import com.bstek.urule.console.servlet.URuleServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author mortalliao
 */
@Component
public class URuleServletRegistration {
    @Bean
    public ServletRegistrationBean registerURuleServlet() {
        return new ServletRegistrationBean(new URuleServlet(), "/urule/*");
    }

    @Bean
    public ServletRegistrationBean registerIndexServlet() {
        return new ServletRegistrationBean(new IndexServlet(), "/urule");
    }
}
