package win.mortalliao.test.mapper;

import org.apache.ibatis.annotations.Param;
import win.mortalliao.starter.common.repository.SuperMapper;
import win.mortalliao.test.entity.Test;

/**
 * 测试表 Mapper 接口
 *
 * @author liaoyuajin
 * @since 2017-11-16
 */
public interface TestMapper extends SuperMapper<Test> {

    int delete(Long id);

    int deleteTest(@Param("id") Long id, @Param("id2") Long id2);
}
