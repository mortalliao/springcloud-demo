package win.mortalliao.jwt.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author mortalliao
 */
@Slf4j
@Aspect
@Component
public class HttpAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void request() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getRequest() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void post() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void put() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void delete() {
    }

    @Before("request() or getRequest() or post() or put() or delete()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("--------------记录HTTP请求 开始---------------");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        // url
        log.info("url={}", request.getRequestURL());

        // method
        log.info("method={}", request.getMethod());

        // ip
        log.info("ip={}", request.getRemoteAddr());

        // 类方法
        log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        // 参数
        log.info("args={}", Arrays.asList(joinPoint.getArgs()));
    }

    @After("request() or getRequest() or post() or put() or delete()")
    public void doAfter() {
        log.info("start return .....");
    }

    @AfterReturning(returning = "object", pointcut = "request() or getRequest() or post() or put() or delete()")
    public void doAfterReturning(Object object) {
        if (object != null) {
            log.info("response={}", object.toString());
        }
        log.info("--------------记录HTTP请求 结束--------------");
    }
}
