package win.mortalliao.auth.client.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mortal
 */
@Data
public class ServiceAuthConfig {
    @Value("${auth.client.pub-key.path}")
    private String pubKeyPath;

    @Value("${auth.client.id:null}")
    private String clientId;

    @Value("${auth.client.secret}")
    private String clientSecret;

    @Value("${auth.client.token-header}")
    private String tokenHeader;

    @Value("${spring.application.name}")
    private String applicationName;

    public String getToken(HttpServletRequest request) {
        return request.getHeader(this.getTokenHeader());
    }

}
