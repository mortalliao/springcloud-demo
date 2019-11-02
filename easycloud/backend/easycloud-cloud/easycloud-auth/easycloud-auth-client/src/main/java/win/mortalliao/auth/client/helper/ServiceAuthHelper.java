
package win.mortalliao.auth.client.helper;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import win.mortalliao.auth.client.config.ServiceAuthConfig;
import win.mortalliao.auth.client.exception.JwtIllegalArgumentException;
import win.mortalliao.auth.client.exception.JwtSignatureException;
import win.mortalliao.auth.client.exception.JwtTokenExpiredException;
import win.mortalliao.auth.client.feign.ServiceAuthFeign;
import win.mortalliao.auth.common.jwt.JwtHelper;
import win.mortalliao.auth.common.jwt.JwtInfo;

import java.util.List;

/**
 * @author mortal
 */
@Configuration
@Slf4j
@EnableScheduling
public class ServiceAuthHelper {

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;

    @Autowired
    private ServiceAuthFeign serviceAuthFeign;

    /**
     * 允许的客户端
     */
    private List<String> allowedClient;

    /**
     * 客户端token
     */
    private String clientToken;

    public JwtInfo getInfoFromToken(String token) throws JwtTokenExpiredException, JwtSignatureException, JwtIllegalArgumentException {
        try {
            return JwtHelper.getInfoFromToken(token, serviceAuthConfig.getPubKeyPath());
        } catch (ExpiredJwtException ex) {
            throw new JwtTokenExpiredException("Client token expired!");
        } catch (SignatureException ex) {
            throw new JwtSignatureException("Client token signature error!");
        } catch (IllegalArgumentException ex) {
            throw new JwtIllegalArgumentException("Client token is null or empty!");
        }
    }

    /**
     * 刷新允许的客户端
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void refreshAllowedClient() {
//        log.info("refresh allowedClient.....");
//        BaseResponse resp = serviceAuthFeign.getAllowedClient(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
//        if (resp.getStatus() == 200) {
//            ObjectRestResponse<List<String>> allowedClient = (ObjectRestResponse<List<String>>) resp;
//            this.allowedClient = allowedClient.getData();
//        }
    }

    /**
     * 刷新客户端token
     */
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void refreshClientToken() {
//        log.info("refresh client token.....");
//        BaseResponse resp = serviceAuthFeign.getAccessToken(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
//        if (resp.getStatus() == 200) {
//            ObjectRestResponse<String> clientToken = (ObjectRestResponse<String>) resp;
//            this.clientToken = clientToken.getData();
//        }
    }

    public String getClientToken() {
        if (this.clientToken == null) {
            this.refreshClientToken();
        }
        return clientToken;
    }

    public List<String> getAllowedClient() {
        if (this.allowedClient == null) {
            this.refreshAllowedClient();
        }
        return allowedClient;
    }

}