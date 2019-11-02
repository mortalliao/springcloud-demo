package win.mortalliao.admin.service.impl;

import win.mortalliao.admin.entity.User;
import win.mortalliao.admin.mapper.UserMapper;
import win.mortalliao.admin.service.UserService;
import win.mortalliao.admin.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, User> implements UserService {
	
}
