package win.mortalliao.admin.service.impl;

import win.mortalliao.admin.entity.Group;
import win.mortalliao.admin.mapper.GroupMapper;
import win.mortalliao.admin.service.GroupService;
import win.mortalliao.admin.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户组（部门）表 服务实现类
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@Service
public class GroupServiceImpl extends SuperServiceImpl<GroupMapper, Group> implements GroupService {
	
}
