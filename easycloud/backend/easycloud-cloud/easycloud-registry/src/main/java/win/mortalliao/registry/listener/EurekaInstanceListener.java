package win.mortalliao.registry.listener;

import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Objects;

/**
 * Created by mortalliao
 * Description: 用于监听Eureka服务停机通知
 * Date: 2017-09-24
 * Time: 13:25
 */
@Configuration
@Slf4j
@EnableScheduling
public class EurekaInstanceListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        //服务挂掉自动通知
        if (applicationEvent instanceof EurekaInstanceCanceledEvent) {
            EurekaInstanceCanceledEvent event = (EurekaInstanceCanceledEvent) applicationEvent;
            //获取当前Eureka示例中的节点信息
            PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
            Applications applications = registry.getApplications();
            //便利获取已注册节点中与当前失效节点ID一致 的节点信息
            applications.getRegisteredApplications().forEach(registryApplication -> {
                registryApplication.getInstances().forEach(instance -> {
                    if (Objects.equals(instance.getInstanceId(), event.getServerId())) {
                        log.info("服务：{}挂了。。。", instance.getAppName());
                    }
                });
            });
        }
        if (applicationEvent instanceof EurekaInstanceRegisteredEvent) {
            EurekaInstanceRegisteredEvent event = (EurekaInstanceRegisteredEvent) applicationEvent;
            log.info("服务：{}注册成功。。。", event.getInstanceInfo().getAppName());
        }
        if (applicationEvent instanceof EurekaInstanceRenewedEvent) {
            EurekaInstanceRenewedEvent event = (EurekaInstanceRenewedEvent) applicationEvent;
            log.info("心跳检测服务：{}。。。", event.getInstanceInfo().getAppName());
        }
        if (applicationEvent instanceof EurekaRegistryAvailableEvent) {
            log.info("注册中心服务：已经可用。。。");
        }
    }

}
