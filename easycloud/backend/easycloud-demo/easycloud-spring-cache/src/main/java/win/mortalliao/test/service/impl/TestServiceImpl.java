package win.mortalliao.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    //    @Log
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void txTest(String name1, String name2) {
        Test test1 = selectById(63);
        Test test2 = selectById(64);

        test1.setName(name1);
        updateById(test1);

        //if (true) {
        //    throw new NullPointerException();
        //}

        test2.setName(name2);
        updateById(test2);
    }

    @Override
    public Boolean delete(Long id) {
        int delete = mapper.delete(id);
        return delete > 0;
    }

    @Override
    public boolean deleteTest(Long id, Long id2) {
        return  mapper.deleteTest(id , id2) >0;
    }
}
