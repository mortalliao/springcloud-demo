package win.mortalliao.jwt.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.jwt.config.jwt.JwtAuthenticationRequest;
import win.mortalliao.jwt.config.jwt.JwtAuthenticationResponse;
import win.mortalliao.jwt.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mortalliao
 */
@RestController
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    /**
     * 用户注册
     *
     * @param addedUser 新增用户
     * @return 新增用户
     */
    @PostMapping(value = "${jwt.route.authentication.register}")
    public User register(@RequestBody User addedUser) {
        return authService.register(addedUser);
    }

    /**
     * 获取token
     *
     * @param authenticationRequest jwt请求封装
     * @return token
     */
    @PostMapping(value = "${jwt.route.authentication.path}")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) {
        final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    /**
     * 刷新token
     * @param request request获取token
     * @return 新的token
     */
    @GetMapping(value = "${jwt.route.authentication.refresh}")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if (refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }

}
