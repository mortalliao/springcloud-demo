package win.mortalliao.admin.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.admin.entity.Resource;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author mortalliao
 * @since 2017-09-30
 */
@RestController
@RequestMapping("/admin/resource")
@Api(description = "资源表", tags = "资源表")
public class ResourceController extends SuperController<Resource> {
	
}
