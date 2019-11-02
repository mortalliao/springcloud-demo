package win.mortalliao.starter.common.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import win.mortalliao.starter.common.entity.BaseEntity;
import win.mortalliao.starter.common.entity.PageSearch;

import java.io.Serializable;

/**
 * @author liaoyujian
 */
public interface BaseService<T extends BaseEntity<T>> extends IService<T> {
    /**
     * 创建数据
     * id由后端生成
     * 注解TableId的字段设为null，而后根据TableId.type()生成
     *
     * @param t 实体
     * @return 成功与否
     */
    Boolean create(T t);

    /**
     * 更新数据
     * 根据id选择性更新
     * id支持String类型和Long类型
     *
     * @param id      id
     * @param version 版本号
     * @param t       数据
     * @return 成功与否
     */
    Boolean update(Serializable id, Long version, T t);

    /**
     * 分页查询
     *
     * @param currentPage 当前页
     * @param pageSize    页大小
     * @param pageSearch  查询参数
     * @return page
     */
    Page<T> pageSearch(int currentPage, int pageSize, PageSearch pageSearch);
}
