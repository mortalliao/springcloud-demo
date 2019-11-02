package win.mortalliao.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by mortalliao
 * Description:
 */
@TableName("admin_permission_resource")
@Data
@Accessors(chain = true)
public class PermissionResource extends SuperEntity<PermissionResource> {

    @TableField("permission_id")
    private Long permissionId;

    @TableField("resource_id")
    private Long resourceId;
}
