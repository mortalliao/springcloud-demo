package win.mortalliao.auth.server.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import win.mortalliao.auth.common.jwt.JwtHelper;
import win.mortalliao.auth.common.jwt.JwtInfo;

/**
 * @author mortal
 * 生成、解析 服务对服务鉴权token
 */
@Configuration
public class ClientTokenUtil {

    @Value("${client.expire}")
    private int expire;

    @Value("${client.pri-key.path}")
    private String priKeyPath;

    @Value("${client.pub-key.path}")
    private String pubKeyPath;

    public String generateToken(JwtInfo jwtInfo) {
        return JwtHelper.generateToken(jwtInfo, priKeyPath, expire);
    }

    public JwtInfo getInfoFromToken(String token) {
        return JwtHelper.getInfoFromToken(token, pubKeyPath);
    }

}
