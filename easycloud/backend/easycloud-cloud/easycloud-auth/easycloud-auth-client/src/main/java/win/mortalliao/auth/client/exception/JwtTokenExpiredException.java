package win.mortalliao.auth.client.exception;

/**
 * @author mortal
 * JWT令牌过期
 */
public class JwtTokenExpiredException extends Exception {
    public JwtTokenExpiredException(String s) {
        super(s);
    }
}
