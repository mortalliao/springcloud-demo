package win.mortalliao.admin.service.impl;

import win.mortalliao.admin.entity.RoleUser;
import win.mortalliao.admin.mapper.RoleUserMapper;
import win.mortalliao.admin.service.RoleUserService;
import win.mortalliao.admin.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色-用户 中间表 服务实现类
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@Service
public class RoleUserServiceImpl extends SuperServiceImpl<RoleUserMapper, RoleUser> implements RoleUserService {
	
}
