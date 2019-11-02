package com.gzedu.ecloud.testa.remote;

import com.gzedu.ecloud.common.result.Result;
import com.gzedu.ecloud.testa.remote.impl.TestFeignClientImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mortal
 */
@FeignClient(value = "ecloud-test", fallback = TestFeignClientImpl.class)
public interface TestFeignClient {

    @GetMapping("/test/test/{id}")
    public Result get(@PathVariable("id") String id);

    @GetMapping("/test/test/")
    Result page(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize);
}
