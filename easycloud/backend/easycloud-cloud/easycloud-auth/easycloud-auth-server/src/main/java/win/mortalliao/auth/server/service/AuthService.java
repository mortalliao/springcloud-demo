package win.mortalliao.auth.server.service;

import win.mortalliao.auth.server.vo.FrontUser;

/**
 * @author mortal
 */
public interface AuthService {
    /**
     * 获取token
     *
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 刷新token
     *
     * @param oldToken oldToken
     * @return newToken
     */
    String refresh(String oldToken);

    /**
     * 验证token
     *
     * @param token token
     */
    void validate(String token);

    /**
     * 获取用户信息
     *
     * @param token token
     * @return FrontUser
     */
    FrontUser getUserInfo(String token);

    /**
     * 注销token
     *
     * @param token token
     * @return 是否成功
     */
    Boolean invalid(String token);
}
