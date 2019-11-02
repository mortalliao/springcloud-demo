package win.mortalliao.admin.service;

import com.baomidou.mybatisplus.service.IService;
import win.mortalliao.admin.entity.SuperEntity;

/**
 * @author liaoyujian
 *
 */
public interface SuperService<T extends SuperEntity<T>> extends IService<T> {
    /**
     * 创建数据
     * id必须后台生成
     */
    Boolean create(T t);

    /**
     * 更新数据
     * 根据id选择性更新
     * @param id id
     * @param version 版本号
     * @param t 数据
     * @return 成功与否
     */
    Boolean update(Long id, Long version, T t);
}
