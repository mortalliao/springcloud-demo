package win.mortalliao.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author mortalliao
 * Description: 菜单
 */
@TableName("admin_menu")
@Data
@Accessors(chain = true)
public class Menu extends SuperEntity<Menu> {

    private String name;

    private String href;

    private String icon;

    @TableField("order_num")
    private String orderNum;

    private String remark;

    @TableField("parent_id")
    private Long parentId;
}
