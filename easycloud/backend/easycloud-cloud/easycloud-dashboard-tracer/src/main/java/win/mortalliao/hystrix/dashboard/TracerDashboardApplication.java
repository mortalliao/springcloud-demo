package win.mortalliao.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author liaoyujian
 *
 */
@EnableHystrixDashboard
@SpringCloudApplication
public class TracerDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(TracerDashboardApplication.class, args);
    }
}
