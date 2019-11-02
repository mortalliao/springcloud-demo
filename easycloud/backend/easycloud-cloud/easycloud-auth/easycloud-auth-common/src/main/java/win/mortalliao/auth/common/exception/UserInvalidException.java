package win.mortalliao.auth.common.exception;


import win.mortalliao.common.api.exception.BaseException;
import win.mortalliao.common.api.result.ResultEnum;

/**
 * @author mortal
 */
public class UserInvalidException extends BaseException {

    public UserInvalidException(String message) {
        super(message, ResultEnum.AUTH_USER_INVALID.getStatus());
    }
}
