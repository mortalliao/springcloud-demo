package win.mortalliao.admin.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.admin.entity.RoleUser;

/**
 * <p>
 * 角色-用户 中间表 前端控制器
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@RestController
@RequestMapping("/admin/roleUser")
@Api(description = "角色-用户 中间表", tags = "角色-用户 中间表")
public class RoleUserController extends SuperController<RoleUser> {
	
}