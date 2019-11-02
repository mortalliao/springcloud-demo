package win.mortalliao.admin.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.admin.entity.Menu;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@RestController
@RequestMapping("/admin/menu")
@Api(description = "菜单表", tags = "菜单表")
public class MenuController extends SuperController<Menu> {
	
}
