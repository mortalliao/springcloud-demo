package win.mortalliao.test.service;

import win.mortalliao.starter.common.service.BaseService;
import win.mortalliao.test.entity.Test;

/**
 * 测试表 服务类
 *
 * @author liaoyuajin
 * @since 2017-11-16
 */
public interface TestService extends BaseService<Test> {

    void txTest(String name1, String name2);

    Boolean delete(Long id);

    boolean deleteTest(Long id, Long id2);
}
