package win.mortalliao.starter.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import win.mortalliao.starter.common.context.RequestContext;
import win.mortalliao.starter.common.util.SystemTimer;

import java.util.Arrays;

/**
 * @author liaoyujian
 * controller 切面
 */
@Aspect
@Component
@Slf4j
public class HttpAspect {

    @Pointcut("execution(public * win.mortalliao..*.controller.*.*(..)) && !execution(public * win.mortalliao..*.controller.*.initBinder(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("--------------记录HTTP请求 开始--------------");

        // url
        log.info("url={}", RequestContext.getURL());

        // method
        log.info("method={}", RequestContext.getMethod());

        // ip
        log.info("ip={}", RequestContext.getIpAddress());

        // 类
        log.info("class={}", joinPoint.getTarget().getClass().getName());

        // 类方法
        log.info("class_method={}", joinPoint.getSignature().getName());

        // 参数
        log.info("args={}", Arrays.asList(joinPoint.getArgs()));
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = SystemTimer.currentTimeMillis();
        Object object = pjp.proceed();
        long endTime = SystemTimer.currentTimeMillis();
        log.info("cost={}ms", endTime - startTime);
        return object;
    }

    @After("log()")
    public void doAfter() {
        log.info("start return .....");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        if (object != null) {
            log.info("response={}", object.toString());
        }
        log.info("--------------记录HTTP请求 结束--------------");
    }

    @AfterThrowing(throwing = "ex", pointcut = "log()")
    public void doAfterThrow(Throwable ex) {
        log.info("--------------接口异常 结束--------------");
    }
}
