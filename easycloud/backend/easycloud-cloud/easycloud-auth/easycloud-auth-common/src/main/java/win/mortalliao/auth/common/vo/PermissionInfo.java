package win.mortalliao.auth.common.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author mortal
 */
@Data
@Accessors(chain = true)
public class PermissionInfo implements Serializable{

    private String code;

    private String type;

    private String uri;

    private String method;

    private String name;

    private String menu;

}
