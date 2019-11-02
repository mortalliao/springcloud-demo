package win.mortalliao.test.service;

import com.baomidou.mybatisplus.plugins.Page;
import win.mortalliao.starter.common.service.BaseService;
import win.mortalliao.test.entity.Test;

/**
 * 测试表 服务类
 *
 * @author liaoyuajin
 * @since 2017-11-16
 */
public interface TestService extends BaseService<Test> {

    Test findByName(String name);

    boolean updateCache(Test test);

    Page findPage(Integer currentPage, Integer pageSize);
}
