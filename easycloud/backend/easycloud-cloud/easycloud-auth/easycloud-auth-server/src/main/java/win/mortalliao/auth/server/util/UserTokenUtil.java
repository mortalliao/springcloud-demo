package win.mortalliao.auth.server.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import win.mortalliao.auth.common.jwt.JwtHelper;
import win.mortalliao.auth.common.jwt.JwtInfo;

/**
 * @author mortal
 * 生成、解析 用户对服务鉴权token
 */
@Component
public class UserTokenUtil {

    @Value("${jwt.expire}")
    private int expire;

    @Value("${jwt.pri-key.path}")
    private String priKeyPath;

    @Value("${jwt.pub-key.path}")
    private String pubKeyPath;

    public String generateToken(JwtInfo jwtInfo) {
        return JwtHelper.generateToken(jwtInfo, priKeyPath, expire);
    }

    public JwtInfo getInfoFromToken(String token) {
        return JwtHelper.getInfoFromToken(token, pubKeyPath);
    }

}
