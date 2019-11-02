package win.mortalliao.admin.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.common.entity.Result;
import win.mortalliao.common.utils.ResultUtil;

/**
 * @author liaoyujian
 *
 * 全局异常处理
 */
@ControllerAdvice(annotations = RestController.class) // 处理 @RestController注解过的类的异常抛出
@ResponseBody // 如果返回的为json数据或其它对象，添加该注解
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = NullPointerException.class) //添加全局异常处理流程，根据需要设置需要处理的异常
    public Result handle(Exception e) {
        logger.error("【系统异常】 {}", e);
        return ResultUtil.error("未知错误");
    }

}
