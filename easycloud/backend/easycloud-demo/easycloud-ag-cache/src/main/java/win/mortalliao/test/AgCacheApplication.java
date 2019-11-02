package win.mortalliao.test;

import com.ace.cache.EnableAceCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author mortal
 */
//@EnableFeignClients
//@EnableCircuitBreaker
//@EnableDiscoveryClient
@EnableAceCache
@SpringBootApplication
@ComponentScan(basePackages = {"win.mortalliao"})
public class AgCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgCacheApplication.class, args);
    }
}
