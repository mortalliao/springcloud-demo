package win.mortalliao.admin.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author mortalliao
 * Description: 角色
 */
@TableName("admin_role")
@Data
@Accessors(chain = true)
public class Role extends SuperEntity<Role>{

    private String name;

    private String code;

    private byte status; // 角色状态

    private String remark;

}
