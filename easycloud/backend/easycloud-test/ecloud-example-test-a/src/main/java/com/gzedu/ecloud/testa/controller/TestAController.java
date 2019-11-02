package com.gzedu.ecloud.testa.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.gzedu.ecloud.common.result.Result;
import com.gzedu.ecloud.common.result.ResultData;
import com.gzedu.ecloud.testa.entity.TestA;
import com.gzedu.ecloud.testa.remote.TestFeignClient;
import com.gzedu.ecloud.testa.service.TestAService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * 前端控制器
 *
 * @author liaoyuajin
 * @since 2017-11-17
 */
@RestController
@RequestMapping("/testa/test-a")
@Api(description = "", tags = "")
public class TestAController {

    @Autowired
    private TestFeignClient testFeignClient;

    @Autowired
    private TestAService testAService;

    @ApiOperation("测试一下分页")
    @GetMapping("/")
    public Result test() {
        Page<TestA> testAPage = testAService.selectPage(new Page<>(1, 10));
        return ResultData.page(testAPage);
    }

    @ApiOperation("测试一下按Id查询")
    @GetMapping("/single")
    public Result test1() {
        TestA testA = testAService.selectById("10asdasd");
        return ResultData.success(testA);
    }

    @ApiOperation("测试一下新增")
    @PostMapping("/save")
    public Result test2(@RequestBody TestA testA) {
        testA.setTestId(null);
        testAService.insert(testA);
        return ResultData.success(testA);
    }

    @ApiOperation("测试远程调用，data中为实体对象")
    @GetMapping("/remote")
    public Result test3() {
        Result result = testFeignClient.get("65");
        Integer status = result.getStatus();
        // 实体对象将转为LinkedHashMap
        LinkedHashMap data = (LinkedHashMap) result.getData();
        LinkedHashMap mapData = result.dataMap();
        // getXxx 转换类型
        // 不带小数点的数字
        Integer id = result.getInteger("id");
        // 因为id不是String类型的，所以返回null
        String id2 = result.getString("id");
        String address = result.getString("address");
        // 带小数点的数字
        Double score = result.getDouble("score");
        return result;
    }

    @ApiOperation("测试远程调用，分页对象")
    @GetMapping("/page")
    public Result page() {
        Result result = testFeignClient.page(1, 2);
        Boolean success = result.isSuccess();
        Boolean error = result.isError();
        Boolean fail = result.isFail();
        int currentPage = result.currentPage();
        int pageSize = result.pageSize();
        long totalCount = result.totalCount();
        long totalPage = result.totalPage();
        ArrayList arrayList = result.dataList();
        return result;
    }
}

