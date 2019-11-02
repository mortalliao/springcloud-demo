package com.gzedu.ecloud.test.mapper;

import com.gzedu.ecloud.common.repository.SuperMapper;
import com.gzedu.ecloud.test.entity.Test;
import org.apache.ibatis.annotations.Param;

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
