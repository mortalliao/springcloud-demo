package win.mortalliao.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author mortal
 */
//@EnableFeignClients
//@EnableCircuitBreaker
//@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"win.mortalliao"})
public class MailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class, args);
    }
}
