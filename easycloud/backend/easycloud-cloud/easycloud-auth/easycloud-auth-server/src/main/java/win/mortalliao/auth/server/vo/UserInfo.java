package win.mortalliao.auth.server.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mortal
 */
@Data
public class UserInfo implements Serializable {

    public String id;

    public String username;

    public String password;

    public String name;

    private String description;

    private Date updTime;

}
