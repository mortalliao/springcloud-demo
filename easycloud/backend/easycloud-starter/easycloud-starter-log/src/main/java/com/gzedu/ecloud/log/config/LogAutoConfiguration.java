package com.gzedu.ecloud.log.config;

import com.gzedu.ecloud.log.annotation.Log;
import com.gzedu.ecloud.log.interceptor.LogMethodInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author liaoyujian
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(LogProperties.class)
public class LogAutoConfiguration extends AbstractPointcutAdvisor {

    private Pointcut pointcut;

    private Advice advice;

    @Autowired
    private LogProperties logProperties;

    @PostConstruct
    public void init() {
        log.info("init LogAutoConfiguration start");
        this.pointcut = new AnnotationMatchingPointcut(null, Log.class);
        this.advice = new LogMethodInterceptor(logProperties.getExcludes());
        log.info("init LogAutoConfiguration end");
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }

}
