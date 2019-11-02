package win.mortalliao.auth.common.exception;


import win.mortalliao.common.api.exception.BaseException;
import win.mortalliao.common.api.result.ResultEnum;

/**
 * @author mortal
 */
public class ClientInvalidException extends BaseException {

    public ClientInvalidException(String message) {
        super(message, ResultEnum.AUTH_CLIENT_INVALID.getStatus());
    }
}
