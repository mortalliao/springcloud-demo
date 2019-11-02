package win.mortalliao.mail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import win.mortalliao.mail.entity.Test;
import win.mortalliao.mail.mapper.TestMapper;
import win.mortalliao.mail.service.MailService;
import win.mortalliao.mail.service.TestService;
import win.mortalliao.starter.common.service.impl.BaseServiceImpl;

/**
 * 测试表 服务实现类
 *
 * @author liaoyuajin
 * @since 2017-11-16
 */
@Service
public class TestServiceImpl extends BaseServiceImpl<TestMapper, Test> implements TestService {

    @Autowired
    MailService mailService;

    @Override
    public void sendSimpleMail() throws Exception {
        mailService.sendSimpleMail("2533011924@qq.com", "测试Subject", "测试Content");
    }

}
