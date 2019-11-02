package win.mortalliao.jwt.config.jwt;

import java.io.Serializable;

/**
 * @author mortalliao
 */
public class JwtAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
