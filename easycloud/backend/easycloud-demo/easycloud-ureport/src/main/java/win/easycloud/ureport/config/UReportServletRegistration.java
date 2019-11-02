package win.easycloud.ureport.config;

import com.bstek.ureport.UReportPropertyPlaceholderConfigurer;
import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;

/**
 * @author mortalliao
 */
@Configuration
@ImportResource("classpath:ureport-console-context.xml")
public class UReportServletRegistration {

    @Bean
    public ServletRegistrationBean buildUReportServlet(){
        return new ServletRegistrationBean(new UReportServlet(), "/ureport/*");
    }

    @Bean
    public UReportPropertyPlaceholderConfigurer buildUfloPropertyPlaceholderConfigurer() {
        UReportPropertyPlaceholderConfigurer uReportPropertyPlaceholderConfigurer = new UReportPropertyPlaceholderConfigurer();
        uReportPropertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        uReportPropertyPlaceholderConfigurer.setLocation(new ClassPathResource("config.properties"));
        return uReportPropertyPlaceholderConfigurer;
    }
}
