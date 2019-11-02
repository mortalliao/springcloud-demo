package win.mortalliao.auth.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import win.mortalliao.auth.server.service.AuthService;
import win.mortalliao.auth.server.vo.FrontUser;
import win.mortalliao.auth.server.vo.JwtAuthenticationRequest;
import win.mortalliao.auth.server.vo.JwtAuthenticationResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mortal
 */
@RestController
@RequestMapping("jwt")
@Api(description = "用户对服务鉴权", tags = "用户对服务鉴权")
public class AuthController {

    @Value("${jwt.token-header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    /**
     * 生成token
     *
     * @param authenticationRequest username password
     * @return JSON token
     */
    @ApiOperation("生成token")
    @PostMapping("token")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) {
        String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    /**
     * 刷新token
     *
     * @param request request
     * @return JSON token
     */
    @ApiOperation("刷新token")
    @GetMapping("refresh")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        return refreshedToken == null ? ResponseEntity.badRequest().body(null) : ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
    }

    /**
     * 验证token
     *
     * @param token token
     * @return ok
     */
    @ApiOperation("验证token")
    @GetMapping("verify")
    public ResponseEntity<?> verify(String token) {
        authService.validate(token);
        return ResponseEntity.ok(true);
    }

    /**
     * 注销token
     *
     * @param token token
     * @return ok
     */
    @ApiOperation("注销token")
    @PostMapping("invalid")
    public ResponseEntity<?> invalid(@RequestHeader("access-token") String token) {
        authService.invalid(token);
        return ResponseEntity.ok(true);
    }

    /**
     * 获取用户信息
     *
     * @param token token
     * @return JSON userInfo
     */
    @ApiOperation("获取用户信息")
    @GetMapping("user")
    public ResponseEntity<?> getUserInfo(String token) {
        FrontUser userInfo = authService.getUserInfo(token);
        return userInfo == null ? ResponseEntity.status(401).body(false) : ResponseEntity.ok(userInfo);
    }
}
