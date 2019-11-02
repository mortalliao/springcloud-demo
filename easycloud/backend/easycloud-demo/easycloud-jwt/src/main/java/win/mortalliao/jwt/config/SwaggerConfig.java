package win.mortalliao.jwt.config;

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
@ConditionalOnExpression("'${swagger.enable}' == 'true'")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描controller
                .apis(RequestHandlerSelectors.basePackage("win.mortalliao.jwt.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //大标题
                .title("测试微服务接口")
                .description("搭建框架，测试服务CRUD")
                //.termsOfServiceUrl("http://www.gzedu.com/")
                .contact(new Contact("mortalliao","",""))
                //版本
                .version("1.0")
                .build();
    }

}
