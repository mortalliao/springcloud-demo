package win.mortalliao.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by mortalliao
 * Description:
 */
@TableName("admin_role_user")
@Data
@Accessors(chain = true)
public class RoleUser extends SuperEntity<RoleUser> {

    @TableField("role_id")
    private Long roleId;

    @TableField("user_id")
    private Long userId;

}
