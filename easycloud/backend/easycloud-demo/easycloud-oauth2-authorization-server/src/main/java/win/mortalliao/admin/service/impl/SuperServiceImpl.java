package win.mortalliao.admin.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import win.mortalliao.admin.entity.SuperEntity;
import win.mortalliao.admin.service.SuperService;

import java.util.Date;

/**
 * @author liaoyujian
 *
 */
public class SuperServiceImpl<M extends BaseMapper<T>, T extends SuperEntity<T>> extends ServiceImpl<M, T> implements SuperService<T> {

    @Override
    public Boolean create(T t) {
        t.setId(null);
        return insert(t);
    }

    @Override
    public Boolean update(Long id, Long version, T t) {
        t.setId(id);
        t.setVersion(version);
        t.setUpdateTime(new Date());
        return updateById(t);
    }

}
