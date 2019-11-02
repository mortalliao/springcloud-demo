package win.mortalliao.test;

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
@ComponentScan(basePackages = {"win.mortalliao"})
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
