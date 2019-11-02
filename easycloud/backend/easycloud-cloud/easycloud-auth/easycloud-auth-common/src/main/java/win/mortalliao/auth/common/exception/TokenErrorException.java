package win.mortalliao.auth.common.exception;


import win.mortalliao.common.api.exception.BaseException;
import win.mortalliao.common.api.result.ResultEnum;

/**
 * @author mortal
 */
public class TokenErrorException extends BaseException {

    public TokenErrorException(String message) {
        super(message, ResultEnum.AUTH_TOKEN_ERROR.getStatus());
    }
}
