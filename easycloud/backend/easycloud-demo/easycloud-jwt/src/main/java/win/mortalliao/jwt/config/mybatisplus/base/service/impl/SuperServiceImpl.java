package win.mortalliao.jwt.config.mybatisplus.base.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import win.mortalliao.jwt.config.mybatisplus.base.service.SuperService;

/**
 * @author liaoyujian
 */
public class SuperServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements SuperService<T> {

}
