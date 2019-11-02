package win.mortalliao.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by mortalliao
 * Description:
 */
@TableName("admin_group_role")
@Data
@Accessors(chain = true)
public class GroupRole extends SuperEntity<GroupRole> {

    @TableField("group_id")
    private Long groupId;

    @TableField("role_id")
    private Long roleId;

}
