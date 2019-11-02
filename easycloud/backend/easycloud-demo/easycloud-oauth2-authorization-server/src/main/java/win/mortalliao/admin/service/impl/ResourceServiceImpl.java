package win.mortalliao.admin.service.impl;

import win.mortalliao.admin.entity.Resource;
import win.mortalliao.admin.mapper.ResourceMapper;
import win.mortalliao.admin.service.ResourceService;
import win.mortalliao.admin.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@Service
public class ResourceServiceImpl extends SuperServiceImpl<ResourceMapper, Resource> implements ResourceService {
	
}
