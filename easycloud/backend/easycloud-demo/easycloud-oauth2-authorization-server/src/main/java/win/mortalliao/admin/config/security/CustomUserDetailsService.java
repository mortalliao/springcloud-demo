package win.mortalliao.admin.config.security;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import win.mortalliao.admin.entity.RoleUser;
import win.mortalliao.admin.entity.User;
import win.mortalliao.admin.service.RoleService;
import win.mortalliao.admin.service.RoleUserService;
import win.mortalliao.admin.service.UserService;

import java.util.stream.Collectors;

/**
 *
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleUserService roleUserService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //User对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用User中的username作为用户名:
        User user = userService.selectOne(new EntityWrapper<User>().eq("username", userName));
        if (user == null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }
        // CustomUserDetails实现UserDetails
        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        customUserDetails.setRoles(roleUserService.selectList(new EntityWrapper<RoleUser>().eq("user_id", user.getId())).stream()
                .map(roleUser -> roleService.selectById(roleUser.getRoleId()))
                .collect(Collectors.toList()));
        return customUserDetails;
    }
}
