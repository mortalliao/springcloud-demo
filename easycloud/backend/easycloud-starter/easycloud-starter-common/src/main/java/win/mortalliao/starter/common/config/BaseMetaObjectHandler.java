package win.mortalliao.starter.common.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import win.mortalliao.starter.common.constant.GlobalConstant;
import win.mortalliao.starter.common.context.RequestContext;

import java.util.Date;

/**
 * @author liaoyujian
 * 公共字段自动填充
 */
public class BaseMetaObjectHandler extends MetaObjectHandler {

    /**
     * insert fill
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("version", 1L, metaObject);
        setFieldValByName("isDeleted", GlobalConstant.NO, metaObject);
        Object createdBy = getFieldValByName("createdBy", metaObject);
        if (createdBy == null) {
            setFieldValByName("createdBy", RequestContext.getIpAddress(), metaObject);
        }
        setFieldValByName("createdDt", new Date(), metaObject);
        Object updatedBy = getFieldValByName("updatedBy", metaObject);
        if (updatedBy == null) {
            setFieldValByName("updatedBy", RequestContext.getIpAddress(), metaObject);
        }
        setFieldValByName("updatedDt", new Date(), metaObject);
    }

    /**
     * update fill
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Object updatedBy = getFieldValByName("updatedBy", metaObject);
        if (updatedBy == null) {
            setFieldValByName("updatedBy", RequestContext.getIpAddress(), metaObject);
        }
        setFieldValByName("updatedDt", new Date(), metaObject);
    }
}
