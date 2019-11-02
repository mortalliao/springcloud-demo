package win.mortalliao.tracer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @author liaoyujian
 *
 */
@EnableZipkinServer
//@EnableZipkinStreamServer
@SpringBootApplication
public class TracerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TracerApplication.class,args);
    }
}
