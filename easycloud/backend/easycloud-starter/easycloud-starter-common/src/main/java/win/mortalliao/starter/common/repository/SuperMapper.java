package win.mortalliao.starter.common.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * @author liaoyujian
 * mapper 父类，注意这个类不要让 mp 扫描到！！
 */
public interface SuperMapper<T> extends BaseMapper<T> {

}
