package com.gzedu.elcoud.feign.aspect;

import com.codingapi.tx.springcloud.interceptor.TxManagerInterceptor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author mortal
 */
@Aspect
@Component
public class TxTransactionAspect implements Ordered {

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Autowired
    private TxManagerInterceptor txManagerInterceptor;

    @Around("execution(* win.mortalliao.*.service.impl.*Impl.*(..)) && execution(* com.baomidou.mybatisplus.service.impl.*Impl.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        return txManagerInterceptor.around(point);
    }
}
