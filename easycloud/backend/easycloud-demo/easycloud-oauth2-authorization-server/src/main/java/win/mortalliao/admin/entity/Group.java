package win.mortalliao.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by mortalliao
 * Description: 用户组 (部门)
 */
@TableName("admin_group")
@Data
@Accessors(chain = true)
public class Group extends SuperEntity<Group> {

    private String name;

    private String remark;

    @TableField("parent_id")
    private Long parentId;

}
