package com.gzedu.ecloud.testb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author mortal
 */
//@EnableFeignClients
//@EnableCircuitBreaker
//@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.gzedu.ecloud"})
public class TestbApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestbApplication.class, args);
    }
}
