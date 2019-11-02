package win.mortalliao.admin.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.admin.entity.Permission;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@RestController
@RequestMapping("/admin/permission")
@Api(description = "权限表", tags = "权限表")
public class PermissionController extends SuperController<Permission> {
	
}
