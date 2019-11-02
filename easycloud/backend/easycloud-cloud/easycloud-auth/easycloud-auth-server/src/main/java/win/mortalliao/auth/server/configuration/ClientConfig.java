package win.mortalliao.auth.server.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author mortal
 */
@Configuration
@Getter
public class ClientConfig {

    @Value("${client.id}")
    private String clientId;

    @Value("${client.secret}")
    private String clientSecret;

    @Value("${client.token-header}")
    private String clientTokenHeader;

}
