package win.mortalliao.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;

/**
 * http://localhost:8001/current?access_token=82308337-416e-4bd1-9eef-a54fbc8a2bba
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableFeignClients //开启扫描Spring Cloud Feign客户端的功能
@EnableCircuitBreaker //开启Hystrix短路器
//@EnableDiscoveryClient
@SpringBootApplication
//@SpringCloudApplication //@SpringCloudApplication = @SpringBootApplication + @EnableDiscoveryClient + @EnableCircuitBreaker
public class ManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

