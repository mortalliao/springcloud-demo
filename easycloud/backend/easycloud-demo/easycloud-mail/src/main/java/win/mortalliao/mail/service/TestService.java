package win.mortalliao.mail.service;

import win.mortalliao.mail.entity.Test;
import win.mortalliao.starter.common.service.BaseService;

/**
 * 测试表 服务类
 *
 * @author liaoyuajin
 * @since 2017-11-16
 */
public interface TestService extends BaseService<Test> {

    public void sendSimpleMail() throws Exception;
}
