package win.mortalliao.admin.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.admin.entity.PermissionResource;

/**
 * <p>
 * 权限-资源 中间表 前端控制器
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@RestController
@RequestMapping("/admin/permissionResource")
@Api(description = "权限-资源 中间表", tags = "权限-资源 中间表")
public class PermissionResourceController extends SuperController<PermissionResource> {
	
}
