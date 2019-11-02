package win.mortalliao.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Email;

import java.util.List;

/**
 * @author mortalliao
 *         Description: 用户
 */
@TableName("admin_user")
@Data
@Accessors(chain = true)
public class User extends SuperEntity<User> {

    private String name;// 姓名

    private String username;//帐号

    @JsonIgnore
    private String password; //密码;

    private String status;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.

    private String address;

    @TableField("phone_number")
    private String phoneNumber;

    @Email
    private String email;

    private String gender;

    @TableField("image_url")
    private String imageUrl;

    private String remark;

    @TableField(exist = false)
    private List<Role> roles;

}
