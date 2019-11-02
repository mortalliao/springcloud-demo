package win.mortalliao.admin.service.impl;

import win.mortalliao.admin.entity.RolePermission;
import win.mortalliao.admin.mapper.RolePermissionMapper;
import win.mortalliao.admin.service.RolePermissionService;
import win.mortalliao.admin.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色-权限 中间表 服务实现类
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@Service
public class RolePermissionServiceImpl extends SuperServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {
	
}
