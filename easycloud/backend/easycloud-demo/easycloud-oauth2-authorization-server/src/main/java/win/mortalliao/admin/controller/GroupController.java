package win.mortalliao.admin.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.admin.entity.Group;

/**
 * <p>
 * 用户组（部门）表 前端控制器
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@RestController
@RequestMapping("/admin/group")
@Api(description = "用户组（部门）表", tags = "用户组（部门）表")
public class GroupController extends SuperController<Group> {
	
}
