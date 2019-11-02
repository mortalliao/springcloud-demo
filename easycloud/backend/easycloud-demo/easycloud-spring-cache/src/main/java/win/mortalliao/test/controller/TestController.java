package win.mortalliao.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/win.mortalliao.test/win.mortalliao.test")
@Api(description = "测试表", tags = "测试表")
public class TestController extends BaseController<Test> {

    @Autowired
    TestService testService;

    @ApiOperation("测试")
    @GetMapping("/123/{name1}/{name2}")
    public Result test(@PathVariable("name1") String name1, @PathVariable("name2") String name2) {
        testService.txTest(name1, name2);
        return ResultData.success();
    }

    @ApiOperation("物理删除")
    @GetMapping("/{id}/delete")
    public Result physicalDelete(@PathVariable("id") Long id) {
        return testService.delete(id) ? ResultData.success() : ResultData.fail();
    }

    @ApiOperation("物理删除XML")
    @GetMapping("/win.mortalliao.test/{id}/{id2}")
    public Result test(@PathVariable("id") Long id, @PathVariable(value = "id2", required = false) Long id2) {
        if (testService.deleteTest(id, id2)) {
            return ResultData.success();
        }
        System.out.println("va5646");
        return ResultData.fail();
    }

}
