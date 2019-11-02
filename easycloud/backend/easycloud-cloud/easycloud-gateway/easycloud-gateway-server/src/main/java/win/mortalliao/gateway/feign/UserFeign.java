package win.mortalliao.gateway.feign;

import feign.Param;
import feign.RequestLine;
import win.mortalliao.auth.common.vo.PermissionInfo;

import java.util.List;

/**
 * @author wanghaobin
 */
public interface UserFeign {
    @RequestLine(value = "GET /api/user/un/{username}/permissions")
    public List<PermissionInfo> getPermissionByUsername(@Param("username") String username);

    @RequestLine(value = "GET /api/permissions")
    List<PermissionInfo> getAllPermissionInfo();
}
