package win.mortalliao.starter.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import win.mortalliao.starter.common.exception.TransactionAbortException;
import win.mortalliao.starter.common.result.Result;
import win.mortalliao.starter.common.result.ResultData;

/**
 * @author liaoyujian
 * Description: 事务异常处理类
 * Date: 2017-09-16
 * Time: 17:09
 */
@Slf4j
@ControllerAdvice
public class TransactionExceptionHandler {

    /**
     * 事务中止异常(自定义)
     *
     * @param e TransactionAbortException
     * @return ResultData
     */
    @ExceptionHandler(value = TransactionAbortException.class)
    @ResponseBody
    public Result handle(TransactionAbortException e) {
        log.error("error:", e);
        return ResultData.error(e.getMessage());
    }

}
