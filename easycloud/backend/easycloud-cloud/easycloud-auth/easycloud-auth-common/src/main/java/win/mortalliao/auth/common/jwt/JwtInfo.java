package win.mortalliao.auth.common.jwt;

/**
 * @author mortal
 */
public interface JwtInfo {
    /**
     * 获取唯一识别凭证名称（用户名或者服务名）
     *
     * @return String
     */
    String getUniqueName();

    /**
     * 获取ID（用户ID或者服务ID）
     *
     * @return String
     */
    String getId();

    /**
     * 获取名称（用户名称或者服务名称）
     *
     * @return String
     */
    String getName();
}
