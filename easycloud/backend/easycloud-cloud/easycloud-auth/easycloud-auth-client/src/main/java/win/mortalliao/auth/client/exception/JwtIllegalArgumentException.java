package win.mortalliao.auth.client.exception;

/**
 * @author mortal
 * JWT非法参数
 */
public class JwtIllegalArgumentException extends Exception {
    public JwtIllegalArgumentException(String s) {
        super(s);
    }
}
