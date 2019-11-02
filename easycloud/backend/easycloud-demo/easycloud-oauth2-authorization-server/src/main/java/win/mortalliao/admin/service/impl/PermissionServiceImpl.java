package win.mortalliao.admin.service.impl;

import win.mortalliao.admin.entity.Permission;
import win.mortalliao.admin.mapper.PermissionMapper;
import win.mortalliao.admin.service.PermissionService;
import win.mortalliao.admin.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@Service
public class PermissionServiceImpl extends SuperServiceImpl<PermissionMapper, Permission> implements PermissionService {
	
}
