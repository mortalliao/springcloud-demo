package win.mortalliao.starter.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import win.mortalliao.starter.common.result.ResultEnum;

/**
 * @author liaoyujian
 * 业务异常父类
 */
@NoArgsConstructor
@Getter
@Setter
public class BaseException extends RuntimeException {
    private int status = ResultEnum.FAIL.getStatus();

    public BaseException(String message, int status) {
        super(message);
        this.status = status;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
