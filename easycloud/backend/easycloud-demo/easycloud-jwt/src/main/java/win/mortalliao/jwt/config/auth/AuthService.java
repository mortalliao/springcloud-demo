package win.mortalliao.jwt.config.auth;

import win.mortalliao.jwt.entity.User;

/**
 * @author mortalliao
 */
public interface AuthService {

    /**
     * 登录时要生成token，完成Spring Security认证，然后返回token给客户端
     */
    User register(User userToAdd);

    /**
     * 注册时将用户密码用BCrypt加密，写入用户角色，由于是开放注册，所以写入角色系统控制，将其写成 ROLE_USER
     */
    String login(String username, String password);

    /**
     * 提供一个可以刷新token的接口 refresh 用于取得新的token
     *
     * @param oldToken 旧token
     * @return newToken 新token
     */
    String refresh(String oldToken);
}
