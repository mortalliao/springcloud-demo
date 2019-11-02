package win.mortalliao.mail.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.mail.entity.Test;
import win.mortalliao.mail.service.MailService;
import win.mortalliao.mail.service.TestService;
import win.mortalliao.starter.common.controller.BaseController;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

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

    @Autowired
    MailService mailService;

    @GetMapping("sendSimpleMail")
    public String sendSimpleMail() throws Exception {
        testService.sendSimpleMail();
        return "success";
    }

    @GetMapping("sendAttachmentsMail")
    public String sendAttachmentsMail() throws Exception {
        ArrayList<File> files = new ArrayList<>();
        files.add(new File("C:\\Users\\morta\\Pictures\\604e48d0ly1fhmwbyl48wj20b40b43zb.jpg"));
        mailService.sendAttachmentsMail("2533011924@qq.com", "测试File", "测试附件content", files);
        return "success";
    }

    @GetMapping("sendTemplateMail")
    public String sendTemplateMail() throws Exception {
        ArrayList<File> files = new ArrayList<>();
        files.add(new File("C:\\Users\\morta\\Pictures\\604e48d0ly1fhmwbyl48wj20b40b43zb.jpg"));
        HashMap<String, Object> content = new HashMap<>(16);
        content.put("title", "title测试");
        content.put("link", "http://www.baidu.com");
        content.put("linkTest", "http://www.baidu.com");
        mailService.sendTemplateMail("2533011924@qq.com", "测试模板", "creationEmail", content, files);
        return "success";
    }

}
