package win.mortalliao.auth.server.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import win.mortalliao.auth.common.constant.ResourceConstant;
import win.mortalliao.auth.common.jwt.JwtUser;
import win.mortalliao.auth.server.feign.UserService;
import win.mortalliao.auth.server.service.AuthService;
import win.mortalliao.auth.server.util.UserTokenUtil;
import win.mortalliao.auth.server.vo.FrontUser;
import win.mortalliao.auth.common.vo.PermissionInfo;
import win.mortalliao.auth.server.vo.UserInfo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mortal
 */
@Service
public class AuthServiceImpl implements AuthService {

    private UserTokenUtil userTokenUtil;
    private UserService userService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    public AuthServiceImpl(UserTokenUtil userTokenUtil, UserService userService) {
        this.userTokenUtil = userTokenUtil;
        this.userService = userService;
    }

    @Override
    public String login(String username, String password) {
        UserInfo userInfo = userService.getUserByUsername(username);
        String token = null;
        if (encoder.matches(password, userInfo.getPassword())) {
            token = userTokenUtil.generateToken(new JwtUser(userInfo.getUsername(), userInfo.getId() + "", userInfo.getName()));
        }
        return token;
    }

    @Override
    public void validate(String token) {
        userTokenUtil.getInfoFromToken(token);
    }

    @Override
    public FrontUser getUserInfo(String token) {
        String username = userTokenUtil.getInfoFromToken(token).getUniqueName();
        if (username == null) {
            return null;
        }
        UserInfo user = userService.getUserByUsername(username);
        FrontUser frontUser = new FrontUser();
        BeanUtils.copyProperties(user, frontUser);

        List<PermissionInfo> permissionInfos = userService.getPermissionByUsername(username);
        // menu权限
        List<PermissionInfo> menus = permissionInfos.parallelStream().filter((permission) -> {
            return permission.getType().equals(ResourceConstant.TYPE_MENU);
        }).collect(Collectors.toList());
        frontUser.setMenus(menus);
        // 其他权限
        List<PermissionInfo> elements = permissionInfos.parallelStream().filter((permission) -> {
            return !permission.getType().equals(ResourceConstant.TYPE_MENU);
        }).collect(Collectors.toList());
        frontUser.setElements(elements);

        return frontUser;
    }

    @Override
    public Boolean invalid(String token) {
        // TODO: 2017/9/11 注销token
        return null;
    }

    @Override
    public String refresh(String oldToken) {
        // TODO: 2017/9/11 刷新token
        return null;
    }
}
