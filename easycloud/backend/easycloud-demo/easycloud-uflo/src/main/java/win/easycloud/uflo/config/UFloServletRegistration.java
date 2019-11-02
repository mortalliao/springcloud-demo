package win.easycloud.uflo.config;

import com.bstek.uflo.UfloPropertyPlaceholderConfigurer;
import com.bstek.uflo.console.UfloServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;

/**
 * @author mortalliao
 */
@Configuration
@ImportResource(value = {"classpath*:uflo-console-context.xml", "classpath:uflo.xml"})
public class UFloServletRegistration {

    /**
     * /uflo/designer 基于网页的流程模版设计器
     * /uflo/todo 默认的待办页面
     * /uflo/central 监控测试页面
     * /uflo/calendar 日历管理页面
     */
    @Bean
    public ServletRegistrationBean buildUFloServlet() {
        return new ServletRegistrationBean(new UfloServlet(), "/uflo/*");
    }

    @Bean
    public UfloPropertyPlaceholderConfigurer buildUfloPropertyPlaceholderConfigurer() {
        UfloPropertyPlaceholderConfigurer ufloPropertyPlaceholderConfigurer = new UfloPropertyPlaceholderConfigurer();
        ufloPropertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        ufloPropertyPlaceholderConfigurer.setLocation(new ClassPathResource("uflo.properties"));
        return ufloPropertyPlaceholderConfigurer;
    }

}
