package win.mortalliao.admin.service.impl;

import win.mortalliao.admin.entity.Menu;
import win.mortalliao.admin.mapper.MenuMapper;
import win.mortalliao.admin.service.MenuService;
import win.mortalliao.admin.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@Service
public class MenuServiceImpl extends SuperServiceImpl<MenuMapper, Menu> implements MenuService {
	
}
