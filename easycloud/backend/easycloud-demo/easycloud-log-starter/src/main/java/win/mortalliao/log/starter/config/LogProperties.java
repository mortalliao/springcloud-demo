package win.mortalliao.log.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

/**
 * @author liaoyujian
 *         Description:
 *         Date: 2017-11-06
 *         Time: 16:46
 */
@ConfigurationProperties(prefix = "mylog")
public class LogProperties {

    private String exclude;

    private String[] excludeArr;

    @PostConstruct
    public void init() {
        this.excludeArr = StringUtils.split(exclude, ",");
    }

    public String getExclude() {
        return exclude;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    public String[] getExcludeArr() {
        return excludeArr;
    }
}
