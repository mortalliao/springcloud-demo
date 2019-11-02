package win.mortalliao.admin.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.admin.entity.GroupRole;

/**
 * <p>
 * 用户组-角色 中间表 前端控制器
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@RestController
@RequestMapping("/admin/groupRole")
@Api(description = "用户组-角色 中间表", tags = "用户组-角色 中间表")
public class GroupRoleController extends SuperController<GroupRole> {
	
}
