package win.mortalliao.auth.client.exception;

/**
 * @author mortal
 * JWT证书异常
 */
public class JwtSignatureException extends Exception {
    public JwtSignatureException(String s) {
        super(s);
    }
}
