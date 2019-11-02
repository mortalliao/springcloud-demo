package win.mortalliao.auth.client.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mortal
 */
@Data
public class UserAuthConfig {
    @Value("${auth.user.pub-key.path}")
    private String pubKeyPath;

    @Value("${auth.user.token-header}")
    private String tokenHeader;

    public String getToken(HttpServletRequest request) {
        return request.getHeader(this.getTokenHeader());
    }

}
