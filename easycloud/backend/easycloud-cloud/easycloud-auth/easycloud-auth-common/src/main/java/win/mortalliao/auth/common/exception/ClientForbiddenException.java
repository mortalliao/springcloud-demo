package win.mortalliao.auth.common.exception;


import win.mortalliao.common.api.exception.BaseException;
import win.mortalliao.common.api.result.ResultEnum;

/**
 * @author mortal
 */
public class ClientForbiddenException extends BaseException {

    public ClientForbiddenException(String message) {
        super(message, ResultEnum.AUTH_CLIENT_FORBIDDEN.getStatus());
    }
}
