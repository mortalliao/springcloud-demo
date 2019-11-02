package win.mortalliao.admin.config.mybatisplus;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author liaoyujian
 *         <p>
 *         公共字段自动填充
 *         mybatis-plus版本2.0.9+
 */
public class CommonMetaObjectHandler extends MetaObjectHandler {

    /**
     * insert fill
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //Object isDeleted = getFieldValByName("isDeleted", metaObject);
        //setFieldValByName("version", 1L, metaObject);
        //setFieldValByName("isDeleted", YesOrNo.NO, metaObject);
        //setFieldValByName("createdBy", "liaoyujian", metaObject);
        //setFieldValByName("createdDt", new Date(), metaObject);
        //setFieldValByName("updatedBy", "liaoyujian", metaObject);
        //setFieldValByName("updatedDt", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //setFieldValByName("updatedBy", "testMan", metaObject);
        //setFieldValByName("updatedDt", new Date(), metaObject);
    }
}
