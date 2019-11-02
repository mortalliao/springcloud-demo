package win.mortalliao.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author mortalliao
 * http://localhost:8000/oauth/token?username=admin&password=admin&grant_type=password&scope=select&client_id=client_2&client_secret=123456
 *
 * TestController
 */
@EnableFeignClients //开启扫描Spring Cloud Feign客户端的功能
@EnableCircuitBreaker //开启Hystrix短路器
@EnableDiscoveryClient // 将服务注册到eureka
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
}
