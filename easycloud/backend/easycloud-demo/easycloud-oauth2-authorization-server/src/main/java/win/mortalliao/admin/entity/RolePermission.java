package win.mortalliao.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by mortalliao
 * Description:
 */
@TableName("admin_role_permission")
@Data
@Accessors(chain = true)
public class RolePermission extends SuperEntity<RolePermission> {

    @TableField("role_id")
    private Long roleId;

    @TableField("permission_id")
    private Long permissionId;
}
