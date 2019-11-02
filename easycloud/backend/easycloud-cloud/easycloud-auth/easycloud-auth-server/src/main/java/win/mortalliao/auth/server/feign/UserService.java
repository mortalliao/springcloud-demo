package win.mortalliao.auth.server.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import win.mortalliao.auth.server.configuration.FeignConfiguration;
import win.mortalliao.auth.common.vo.PermissionInfo;
import win.mortalliao.auth.server.vo.UserInfo;

import java.util.List;

/**
 * @author mortal
 */
@FeignClient(value = "ace-admin", configuration = FeignConfiguration.class)
public interface UserService {

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return UserInfo
     */
    @GetMapping("/api/user/username/{username}")
    public UserInfo getUserByUsername(@PathVariable("username") String username);

    /**
     * 根据用户名获取用户权限列表
     *
     * @param username 用户名
     * @return List<PermissionInfo>
     */
    @GetMapping("/api/user/un/{username}/permissions")
    public List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username);

    /**
     * 获取所有的权限列表
     *
     * @return List<PermissionInfo>
     */
    @GetMapping("/api/permissions")
    List<PermissionInfo> getAllPermissionInfo();
}
