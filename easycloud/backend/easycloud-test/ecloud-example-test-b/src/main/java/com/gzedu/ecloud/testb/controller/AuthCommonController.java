package com.gzedu.ecloud.testb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mortal
 */
@RestController
@RequestMapping(value = "/")
@RefreshScope
//implements ConfigChangeHanlder
public class AuthCommonController  {

    @Value("${test}")
    private String test;

    //@Override
    //public void onConfigChanged(Map<String, Object> changedConfigs) {
    //    if (changedConfigs.containsKey("test")) {
    //        System.out.println("remote:" + test);
    //        test = changedConfigs.get("test").toString();
    //    }
    //}
    //
    //@GetMapping()
    //public String test1() {
    //    String str = ResourceUtils.getProperty("test");
    //    System.out.println(str);
    //    return str;
    //}

    @GetMapping("/test")
    public String test2() {
        System.out.println(test);
        return test;
    }

}
