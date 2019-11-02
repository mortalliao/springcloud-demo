package com.gzedu.ecloud.log.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

/**
 * @author liaoyujian
 */
@ConfigurationProperties(prefix = "log")
@Getter
@Setter
public class LogProperties {

    private String exclude;

    private String[] excludes;

    @PostConstruct
    public void init() {
        if (exclude != null) {
            this.excludes = exclude.split(",");
        }
    }

}
