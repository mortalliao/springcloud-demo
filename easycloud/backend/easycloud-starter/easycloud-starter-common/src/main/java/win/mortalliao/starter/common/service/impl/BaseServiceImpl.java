package win.mortalliao.starter.common.service.impl;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import win.mortalliao.starter.common.constant.PageSearchConstant;
import win.mortalliao.starter.common.entity.BaseEntity;
import win.mortalliao.starter.common.entity.PageSearch;
import win.mortalliao.starter.common.service.BaseService;

import java.io.Serializable;
import java.util.Map;

/**
 * @author liaoyujian
 */
@Slf4j
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity<T>> extends ServiceImpl<M, T> implements BaseService<T> {

    @Autowired
    protected M mapper;

    @Override
    public Boolean create(@NonNull T t) {
        ReflectionUtils.doWithFields(t.getClass(), field -> {
            field.setAccessible(true);
            field.set(t, null);
        }, field -> field.getAnnotation(TableId.class) != null);
        return insert(t);
    }

    @Override
    public Boolean update(@NonNull Serializable id, @NonNull Long version, @NonNull T t) {
        ReflectionUtils.doWithFields(t.getClass(), field -> {
            field.setAccessible(true);
            if (field.getType() == Long.class) {
                field.set(t, Long.parseLong(id.toString()));
            } else if (field.getType() == String.class) {
                field.set(t, id);
            }
        }, field -> field.getAnnotation(TableId.class) != null);
        t.setVersion(version);
        return updateById(t);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Page<T> pageSearch(@NonNull int currentPage, @NonNull int pageSize, PageSearch pageSearch) {
        Page<T> page = new Page<>(currentPage, pageSize);
        Condition condition = Condition.create();

        if (pageSearch != null) {
            searchConditions(pageSearch.getWhere(), condition);
            sortConditions(pageSearch.getOrderBy(), condition);
        }

        return selectPage(page, condition);
    }

    /**
     * 加载 排序条件
     *
     * @param orderBy   orderBy Map
     * @param condition condition
     */
    private void sortConditions(Map<String, String> orderBy, Condition condition) {
        if (orderBy != null && !orderBy.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            orderBy.forEach((k, v) -> {
                stringBuilder.append(StringUtils.camelToUnderline(k));
                stringBuilder.append("asc".equals(v.toLowerCase()) ? " ASC , " : " DESC ,");
            });
            String orderBySql = stringBuilder.toString().trim();
            condition.orderBy(orderBySql.substring(0, orderBySql.length() - 1));
        } else {
            condition.orderBy(BaseEntity.UPDATED_DT, false);
        }
    }

    /**
     * 加载 查询条件
     *
     * @param where     where Map
     * @param condition condition
     */
    private void searchConditions(Map<String, Object> where, Condition condition) {
        if (where != null && !where.isEmpty()) {
            where.forEach((k, v) -> {
                if (isLoadCondition(PageSearchConstant.SEARCH_EQ, k, v)) {
                    condition.eq(StringUtils.camelToUnderline(k.split(PageSearchConstant.SEARCH_EQ)[0]), v);
                } else if (isLoadCondition(PageSearchConstant.SEARCH_LT, k, v)) {
                    condition.lt(StringUtils.camelToUnderline(k.split(PageSearchConstant.SEARCH_LT)[0]), v);
                } else if (isLoadCondition(PageSearchConstant.SEARCH_LE, k, v)) {
                    condition.le(StringUtils.camelToUnderline(k.split(PageSearchConstant.SEARCH_LE)[0]), v);
                } else if (isLoadCondition(PageSearchConstant.SEARCH_GT, k, v)) {
                    condition.gt(StringUtils.camelToUnderline(k.split(PageSearchConstant.SEARCH_GT)[0]), v);
                } else if (isLoadCondition(PageSearchConstant.SEARCH_GE, k, v)) {
                    condition.ge(StringUtils.camelToUnderline(k.split(PageSearchConstant.SEARCH_GE)[0]), v);
                } else if (isLoadCondition(PageSearchConstant.SEARCH_LLIKE, k, v)) {
                    condition.like(StringUtils.camelToUnderline(k.split(PageSearchConstant.SEARCH_LLIKE)[0]), String.valueOf(v), SqlLike.LEFT);
                } else if (isLoadCondition(PageSearchConstant.SEARCH_RLIKE, k, v)) {
                    condition.like(StringUtils.camelToUnderline(k.split(PageSearchConstant.SEARCH_RLIKE)[0]), String.valueOf(v), SqlLike.RIGHT);
                } else if (isLoadCondition(PageSearchConstant.SEARCH_LIKE, k, v)) {
                    condition.like(StringUtils.camelToUnderline(k.split(PageSearchConstant.SEARCH_LIKE)[0]), String.valueOf(v));
                }
            });
        }
    }

    /**
     * 是否加载 查询条件
     *
     * @param conditionSuffix 查询条件前缀
     * @param k               key
     * @param v               value
     * @return boolean
     */
    private boolean isLoadCondition(String conditionSuffix, String k, Object v) {
        return k.endsWith(conditionSuffix) && null != v && v.toString().length() > 0;
    }

}
