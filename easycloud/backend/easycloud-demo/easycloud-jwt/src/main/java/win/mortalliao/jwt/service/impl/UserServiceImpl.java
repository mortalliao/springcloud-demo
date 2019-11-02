package win.mortalliao.jwt.service.impl;

import win.mortalliao.jwt.config.mybatisplus.base.service.impl.SuperServiceImpl;
import win.mortalliao.jwt.entity.User;
import win.mortalliao.jwt.mapper.UserMapper;
import win.mortalliao.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mortalliao
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        User user = new User();
        user.setUserCode(username);
        return userMapper.selectOne(user);
    }
}
