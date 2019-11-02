package win.mortalliao.admin.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.admin.entity.RolePermission;

/**
 * <p>
 * 角色-权限 中间表 前端控制器
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@RestController
@RequestMapping("/admin/rolePermission")
@Api(description = "角色-权限 中间表", tags = "角色-权限 中间表")
public class RolePermissionController extends SuperController<RolePermission> {
	
}
