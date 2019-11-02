package win.mortalliao.auth.server.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import win.mortalliao.auth.common.vo.PermissionInfo;

import java.util.List;

/**
 * @author mortal
 */
@Data
@Accessors(chain = true)
public class FrontUser {

    public String id;

    public String username;

    public String name;

    private String description;

    private String image;

    private List<PermissionInfo> menus;

    private List<PermissionInfo> elements;

}
