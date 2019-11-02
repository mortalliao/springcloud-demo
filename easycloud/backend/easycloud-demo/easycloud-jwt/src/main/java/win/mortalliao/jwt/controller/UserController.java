package win.mortalliao.jwt.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import win.mortalliao.jwt.config.mybatisplus.base.SuperController;
import win.mortalliao.jwt.entity.User;
import win.mortalliao.jwt.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mortalliao
 */
@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/wlyx/user")
@Api(description = "基础信息表(教师、行政人员)", tags = "基础信息表(教师、行政人员)")
public class UserController extends SuperController<User> {

    @Autowired
    private UserService userService;

    @GetMapping
    public User getUsers() {
        return userService.selectOne(new EntityWrapper<User>().eq(User.USER_CODE,"ok123"));
    }

}
