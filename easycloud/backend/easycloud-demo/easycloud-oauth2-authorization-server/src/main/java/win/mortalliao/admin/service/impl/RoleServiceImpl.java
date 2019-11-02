package win.mortalliao.admin.service.impl;

import win.mortalliao.admin.entity.Role;
import win.mortalliao.admin.mapper.RoleMapper;
import win.mortalliao.admin.service.RoleService;
import win.mortalliao.admin.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@Service
public class RoleServiceImpl extends SuperServiceImpl<RoleMapper, Role> implements RoleService {
	
}
