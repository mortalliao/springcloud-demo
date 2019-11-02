package com.gzedu.ecloud.testa.remote.impl;

import com.gzedu.ecloud.common.result.Result;
import com.gzedu.ecloud.common.result.ResultData;
import com.gzedu.ecloud.testa.remote.TestFeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mortal
 */
@Service
public class TestFeignClientImpl implements TestFeignClient {

    @Override
    public Result get(@PathVariable("id") String id) {
        return ResultData.fail("远程调用失败");
    }

    @Override
    public Result page(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        return ResultData.fail("服务调用失败");
    }
}
