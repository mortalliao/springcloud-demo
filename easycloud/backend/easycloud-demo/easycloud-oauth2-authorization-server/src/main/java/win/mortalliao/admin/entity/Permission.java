package win.mortalliao.admin.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author mortalliao
 *  Description: 权限
 */
@TableName("admin_permission")
@Data
@Accessors(chain = true)
public class Permission extends SuperEntity<Permission>{

    private String name; // 名称

    private String status;

    private String type;// 权限类型，[group|role|user]

    private String remark;
}
