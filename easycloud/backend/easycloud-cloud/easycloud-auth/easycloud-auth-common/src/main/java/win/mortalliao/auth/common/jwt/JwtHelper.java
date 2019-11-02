package win.mortalliao.auth.common.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import win.mortalliao.auth.common.constant.UserConstant;
import win.mortalliao.auth.common.util.RsaKeyUtil;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

/**
 * @author mortal
 */
@Slf4j
public class JwtHelper {

    /**
     * 私钥加密token
     *
     * @param jwtInfo    jwtUser
     * @param priKeyPath 私钥
     * @param expire     过期时间 单位：秒
     * @return String JwtToken
     */
    public static String generateToken(JwtInfo jwtInfo, String priKeyPath, int expire) {
        try {
            return Jwts.builder()
                    .setSubject(jwtInfo.getUniqueName())
                    .claim(UserConstant.JWT_KEY_USER_ID, jwtInfo.getId())
                    .claim(UserConstant.JWT_KEY_NAME, jwtInfo.getName())
                    .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                    .signWith(SignatureAlgorithm.RS256, RsaKeyUtil.getPrivateKey(priKeyPath))
                    .compact();
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            log.error("token生成错误" + e.getMessage(), e);
        }
        return null;
    }

    /**
     * 获取token中的信息
     *
     * @param token      jwtToken
     * @param pubKeyPath 公钥路径
     * @return JwtUser
     */
    public static JwtInfo getInfoFromToken(String token, String pubKeyPath) {
        return Optional.ofNullable(parserToken(token, pubKeyPath))
                .map(Jwt::getBody)
                .map(claims -> new JwtUser(claims.getSubject(),
                        Optional.ofNullable(claims.get(UserConstant.JWT_KEY_USER_ID)).map(Object::toString).orElse(""),
                        Optional.ofNullable(claims.get(UserConstant.JWT_KEY_NAME)).map(Object::toString).orElse("")))
                .orElse(null);
    }

    /**
     * 公钥解析token
     *
     * @param token jwtToken
     * @return Jws<Claims> Jwt中数据声明（Claim）
     */
    private static Jws<Claims> parserToken(String token, String pubKeyPath) {
        try {
            return Jwts.parser().setSigningKey(RsaKeyUtil.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            log.error("token解析错误" + e.getMessage(), e);
        }
        return null;
    }

}
