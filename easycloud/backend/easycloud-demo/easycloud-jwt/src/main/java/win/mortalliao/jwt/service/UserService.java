package win.mortalliao.jwt.service;

import win.mortalliao.jwt.config.mybatisplus.base.service.SuperService;
import win.mortalliao.jwt.entity.User;

/**
 * @author mortalliao
 */
public interface UserService extends SuperService<User> {

    User findByUsername(String username);
}
