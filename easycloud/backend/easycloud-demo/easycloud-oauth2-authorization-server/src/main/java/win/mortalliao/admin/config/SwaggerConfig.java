package win.mortalliao.admin.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liaoyujian
 *
 */
@Configuration
@EnableSwagger2 // 启用 Swagger
@ConditionalOnExpression("'${swagger.enable}' == 'true'") //swagger的开关
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("win.mortalliao.admin.controller")) //扫描controller
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("研修积分系统开放接口")//大标题
                .description("网络研修社区") //简介
                .termsOfServiceUrl("http://www.gzedu.com/") //服务url
                .contact(new Contact("liaoyujian", "", "")) // 作者
                .version("1.0") //版本
                .build();
    }

}
