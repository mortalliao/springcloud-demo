package win.mortalliao.admin.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by SuperS on 2017/9/26.
 *
 * @author SuperS
 */
@RestController
public class TestController {
    @GetMapping("/win.mortalliao.test")
    public String test() {
        return "win.mortalliao.test";
    }

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/test/{id}")
    public String getOrder(@PathVariable String id) {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        return "test id : " + id;
    }
}
