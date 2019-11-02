package win.mortalliao.auth.client.helper;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import win.mortalliao.auth.client.config.UserAuthConfig;
import win.mortalliao.auth.client.exception.JwtIllegalArgumentException;
import win.mortalliao.auth.client.exception.JwtSignatureException;
import win.mortalliao.auth.client.exception.JwtTokenExpiredException;
import win.mortalliao.auth.common.jwt.JwtHelper;
import win.mortalliao.auth.common.jwt.JwtInfo;

/**
 * @author mortal
 */
@Configuration
public class UserAuthHelper {

    @Autowired
    private UserAuthConfig userAuthConfig;

    public JwtInfo getInfoFromToken(String token) throws JwtTokenExpiredException, JwtSignatureException, JwtIllegalArgumentException {
        try {
            return JwtHelper.getInfoFromToken(token, userAuthConfig.getPubKeyPath());
        } catch (ExpiredJwtException ex) {
            throw new JwtTokenExpiredException("User token expired!");
        } catch (SignatureException ex) {
            throw new JwtSignatureException("User token signature error!");
        } catch (IllegalArgumentException ex) {
            throw new JwtIllegalArgumentException("User token is null or empty!");
        }
    }
}
