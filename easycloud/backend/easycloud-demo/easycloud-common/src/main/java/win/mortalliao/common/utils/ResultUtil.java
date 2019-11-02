package win.mortalliao.common.utils;

import win.mortalliao.common.entity.Result;
import win.mortalliao.common.enums.ResultEnum;

/**
 * @author mortalliao
 */
public class ResultUtil {

    public static Result success() {
        return new Result<>(ResultEnum.SUCCESS);
    }

    public static Result success(Object data) {
        return new Result<>(ResultEnum.SUCCESS, data);
    }

    public static Result fail() {
        return new Result<>(ResultEnum.FAIL);
    }

    public static Result fail(String msg) {
        Result result = new Result(ResultEnum.FAIL.getCode(), msg);
        return result;
    }

    public static Result error() {
        return new Result<>(ResultEnum.ERROR);
    }

    public static Result error(String msg) {
        Result result = new Result(ResultEnum.ERROR.getCode(), msg);
        return result;
    }

}
