package win.mortalliao.jwt.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.common.entity.Result;
import win.mortalliao.common.utils.ResultUtil;

/**
 * @author mortalliao
 *         <p>
 *         全局异常处理
 */
@Slf4j
@ResponseBody
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e) {
        log.error("error:", e);
        return ResultUtil.error("未知错误:" + e);
    }

}
