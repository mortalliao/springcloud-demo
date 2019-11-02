package win.mortalliao.jwt.config.mybatisplus;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author mortalliao
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
        //setFieldValByName("version", 1L, metaObject);
        //setFieldValByName("isDeleted", BaseConstant.NO, metaObject);
        //Object createdBy = getFieldValByName("createdBy", metaObject);
        //if (createdBy == null) {
        //    setFieldValByName("createdBy", WebHelper.INSTANCE.getIP(), metaObject);
        //}
        //setFieldValByName("createdDt", new Date(), metaObject);
        //Object updatedBy = getFieldValByName("updatedBy", metaObject);
        //if (updatedBy == null) {
        //    setFieldValByName("updatedBy", WebHelper.INSTANCE.getIP(), metaObject);
        //}
        //setFieldValByName("updatedDt", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //Object updatedBy = getFieldValByName("updatedBy", metaObject);
        //if (updatedBy == null) {
        //    setFieldValByName("updatedBy", WebHelper.INSTANCE.getIP(), metaObject);
        //}
        //setFieldValByName("updatedDt", new Date(), metaObject);
    }
}
