package win.mortalliao.auth.client.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author mortalliao
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum AuthResultEnum {

    /**
     * token异常
     */
    AUTH_TOKEN_ERROR(4000, "token异常"),

    AUTH_TOKEN_ILLEGAL(4030, "非法token"),

    AUTH_TOKEN_EXPIRED(4050, "token已过期"),

    AUTH_TOKEN_SIGNATURE_ERROR(4060, "token签名异常"),

    /**
     * 用户无效访问
     */
    AUTH_USER_INVALID(4100, "用户无效访问"),

    /**
     * 客户端禁止访问
     */
    AUTH_CLIENT_FORBIDDEN(4500, "客户端禁止访问"),

    /**
     * 客户端无效访问
     */
    AUTH_CLIENT_INVALID(4600, "客户端无效访问");

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 提示信息
     */
    private String message;

}
