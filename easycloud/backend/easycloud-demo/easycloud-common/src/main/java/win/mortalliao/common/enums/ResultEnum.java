package win.mortalliao.common.enums;

/**
 * @author mortalliao
 * Description:
 */
public enum ResultEnum {
    ERROR(-1, "服务器出现错误"),

    SUCCESS(0, "成功"),

    FAIL(1, "操作失败");

    private Integer code;

    private String msg;

    ResultEnum() {
    }

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
