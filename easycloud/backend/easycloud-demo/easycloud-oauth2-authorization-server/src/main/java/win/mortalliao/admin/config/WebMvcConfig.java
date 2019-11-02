package win.mortalliao.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/services/**").addResourceLocations("classpath:/templates/services/");
        registry.addResourceHandler("/common/**").addResourceLocations("classpath:/templates/common/");
        //registry.addResourceHandler("/static/**").addResourceLocations("classpath:/templates/static/");
        //registry.addResourceHandler("/common/**").addResourceLocations("classpath:/templates/common/");
        //registry.addResourceHandler("/modules/**").addResourceLocations("classpath:/templates/modules/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        //registry.addInterceptor(new IframeInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
