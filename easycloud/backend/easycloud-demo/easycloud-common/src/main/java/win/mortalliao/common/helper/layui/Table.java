package win.mortalliao.common.helper.layui;

import java.util.List;

/**
 *
 */
public class Table<T> {

    /**
     * 状态码，0代表成功，其它失败
     */
    private Integer code;

    /**
     * 状态信息，一般可为空
     */
    private String msg;

    /**
     * 数据总量
     */
    private Integer count;

    /**
     * 数据，字段是任意的。如：[{"id":1,"username":"贤心"}, {"id":2,"username":"佟丽娅"}]
     */
    private List<T> data;

    public Table(Integer code, Integer count, List<T> data) {
        this.code = code;
        this.msg = "";
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
