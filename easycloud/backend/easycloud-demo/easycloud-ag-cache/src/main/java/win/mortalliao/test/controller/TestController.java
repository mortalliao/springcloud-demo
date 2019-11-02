package win.mortalliao.test.controller;

import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import win.mortalliao.starter.common.controller.BaseController;
import win.mortalliao.starter.common.result.Result;
import win.mortalliao.starter.common.result.ResultData;
import win.mortalliao.test.entity.Test;
import win.mortalliao.test.service.TestService;

/**
 * 测试表 前端控制器
 *
 * @author liaoyuajin
 * @since 2017-11-16
 */
@RestController
@RequestMapping("/test/")
@Api(description = "测试表", tags = "测试表")
public class TestController extends BaseController<Test> {

    @Autowired
    TestService testService;

    @ApiOperation("测试缓存单实体")
    @GetMapping("/search/{name}")
    public Result test(@PathVariable("name") String name) {
        Test test = testService.findByName(name);
        return ResultData.success(test);
    }

    @ApiOperation("测试缓存单实体")
    @GetMapping("/page")
    public Result testPage(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page page= testService.findPage(currentPage, pageSize);
        return ResultData.success(page);
    }

    @ApiOperation("测试清空缓存")
    @PutMapping("/update/{id}")
    public Result testClear(@PathVariable("id") Long id, @RequestBody Test test) {
        Test test1 = testService.selectById(id);
        if (test1 != null) {
            test.setId(id);
            if (testService.updateCache(test)) {
                return ResultData.success(test);
            }
        }
        return ResultData.fail();
    }

}
