package win.mortalliao.admin.service.impl;

import win.mortalliao.admin.entity.PermissionResource;
import win.mortalliao.admin.mapper.PermissionResourceMapper;
import win.mortalliao.admin.service.PermissionResourceService;
import win.mortalliao.admin.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限-资源 中间表 服务实现类
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@Service
public class PermissionResourceServiceImpl extends SuperServiceImpl<PermissionResourceMapper, PermissionResource> implements PermissionResourceService {
	
}
