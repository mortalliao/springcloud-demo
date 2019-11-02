package win.mortalliao.admin.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.admin.entity.Role;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@RestController
@RequestMapping("/admin/role")
@Api(description = "角色表", tags = "角色表")
public class RoleController extends SuperController<Role> {
	
}
