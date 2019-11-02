package win.mortalliao.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by mortalliao
 * Description: 资源
 */
@TableName("admin_resource")
@Data
@Accessors(chain = true)
public class Resource extends SuperEntity<Resource> {

    private String code;

    private String name;

    private String status;

    private String type; // [button|anchor]

    private String url;

    private String method;

    private String remark;

    @TableField("menu_id")
    private Long menuId;

}
