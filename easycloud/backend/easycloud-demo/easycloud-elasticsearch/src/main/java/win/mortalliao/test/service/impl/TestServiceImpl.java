package win.mortalliao.test.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;
import win.mortalliao.starter.common.service.impl.BaseServiceImpl;
import win.mortalliao.test.entity.Test;
import win.mortalliao.test.mapper.TestMapper;
import win.mortalliao.test.service.TestService;

/**
 * 测试表 服务实现类
 *
 * @author liaoyuajin
 * @since 2017-11-16
 */
@Service
public class TestServiceImpl extends BaseServiceImpl<TestMapper, Test> implements TestService {

    @Override
    public Test findByName(String name) {
        Test test = selectOne(new EntityWrapper<Test>().eq(Test.NAME, name));
        return test;
    }

    @Override
    public boolean updateCache(Test test) {
        return updateById(test);
    }

    @Override
    public Page findPage(Integer currentPage, Integer pageSize) {
        return selectPage(new Page<>(currentPage, pageSize));
    }
}
