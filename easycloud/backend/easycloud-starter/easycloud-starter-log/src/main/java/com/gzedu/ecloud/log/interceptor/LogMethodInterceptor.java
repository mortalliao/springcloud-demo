package com.gzedu.ecloud.log.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liaoyujian
 */
@Slf4j
public class LogMethodInterceptor implements MethodInterceptor {
    private List<String> excludes;

    public LogMethodInterceptor(String[] excludes) {
        if (excludes != null) {
            this.excludes = Arrays.asList(excludes);
        } else {
            this.excludes = Collections.emptyList();
        }
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String methodName = invocation.getMethod().getName();
        if (excludes.contains(methodName)) {
            return invocation.proceed();
        }
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = invocation.proceed();
        } catch (Throwable throwable) {
            log.info("service error");
            throw throwable;
        }
        long end = System.currentTimeMillis();
        log.info("log method={}, cost={}", methodName, (end - start));
        return result;
    }
}
