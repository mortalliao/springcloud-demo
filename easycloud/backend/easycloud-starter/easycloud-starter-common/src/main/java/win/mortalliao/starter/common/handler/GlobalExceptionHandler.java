package win.mortalliao.starter.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import win.mortalliao.starter.common.exception.BaseException;
import win.mortalliao.starter.common.result.Result;
import win.mortalliao.starter.common.result.ResultData;
import win.mortalliao.starter.common.result.ResultEnum;
import win.mortalliao.starter.common.util.SystemTimer;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @author mortal
 * 全局异常处理
 */
@ControllerAdvice("com.gzedu.ecloud")
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 业务异常处理
     *
     * @param response response
     * @param e        业务异常继承BaseException
     * @return Result
     */
    @ExceptionHandler(BaseException.class)
    public Result baseExceptionHandler(HttpServletResponse response, BaseException e) {
        log.error(e.getMessage(), e);
        return new Result(e.getStatus(), e.getMessage());
    }

    /**
     * 全局异常处理
     *
     * @param response response
     * @param e        Exception
     * @return Result
     */
    @ExceptionHandler(Exception.class)
    public Result otherExceptionHandler(HttpServletResponse response, Exception e) {
        if (e instanceof HttpMessageNotReadableException) {
            // 请求的数据格式错误
            return new Result(ResultEnum.ERROR_HTTP_MESSAGE_NOT_READABLE);
        } else if (e instanceof SQLIntegrityConstraintViolationException) {
            // 主键冲突异常
            return new Result(ResultEnum.ERROR_SQL_CONSTRAINT);
        }
        long serialNumber = SystemTimer.currentTimeMillis();
        log.error("serial_number=" + serialNumber + " message=" + e.getMessage(), e);
        return new Result(ResultEnum.ERROR, serialNumber);
    }

    /**
     * BindException
     *
     * @param ex Exception
     * @return Result
     */
    @ExceptionHandler(BindException.class)
    public Result processValidationError(BindException ex) {
        log.error(ex.getMessage(), ex);
        String result = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));
        return ResultData.error(result);
    }

    /**
     * MethodArgumentTypeMismatchException
     *
     * @param ex Exception
     * @return Result
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result processArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        log.error(ex.getMessage(), ex);
        return ResultData.error(ex.getMessage());
    }
}
