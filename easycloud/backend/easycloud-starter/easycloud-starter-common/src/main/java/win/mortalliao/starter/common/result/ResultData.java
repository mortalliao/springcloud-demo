package win.mortalliao.starter.common.result;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * @author liaoyujian
 * 构造Result类
 */
public class ResultData {

    public static Result success = new Result(ResultEnum.SUCCESS);
    public static Result fail = new Result(ResultEnum.FAIL);
    public static Result error = new Result(ResultEnum.ERROR);

    /**
     * 操作成功
     *
     * @return Result
     */
    public static Result success() {
        return success;
    }

    /**
     * 操作成功，返回实体对象数据
     *
     * @param data 实体对象数据
     * @return Result
     */
    public static Result success(Object data) {
        if (data instanceof Page) {
            return page((Page) data);
        }
        return new Result(data);
    }

    /**
     * 操作成功，返回mybatis-plus分页对象
     *
     * @param page mybatis-plus分页对象
     * @return PageResult
     */
    public static Result page(Page page) {
        return new Result(page);
    }

    public static Result page(Object data, int currentPage, int pageSize, long totalCount, long totalPage) {
        Result.PageInfo pageInfo = new Result.PageInfo(currentPage, pageSize, totalCount, totalPage);
        return new Result(data, pageInfo);
    }

    /**
     * 操作失败
     *
     * @return Result
     */
    public static Result fail() {
        return fail;
    }

    /**
     * 操作失败，返回提示信息
     *
     * @param msg 提示信息
     * @return Result
     */
    public static Result fail(String msg) {
        return new Result(ResultEnum.FAIL.getStatus(), msg);
    }

    /**
     * 系统异常，出错
     *
     * @return Result
     */
    public static Result error() {
        return error;
    }

    /**
     * 系统异常，出错，返回提示信息
     *
     * @param msg 提示信息
     * @return Result
     */
    public static Result error(String msg) {
        return new Result(ResultEnum.ERROR.getStatus(), msg);
    }

}
