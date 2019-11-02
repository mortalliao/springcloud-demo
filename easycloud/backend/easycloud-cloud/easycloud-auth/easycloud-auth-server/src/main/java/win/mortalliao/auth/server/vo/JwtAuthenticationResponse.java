package win.mortalliao.auth.server.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class JwtAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String token;

}
