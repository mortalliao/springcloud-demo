package win.mortalliao.admin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mortalliao
 *
 * 父实体类
 */
@Data
@ToString
public class SuperEntity<T extends Model> extends Model<T> {

    /**
     * 主键ID
     */
    @TableId("id")
    @ApiModelProperty(hidden = true)
    private Long id;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    /**
     * 数据版本(修改一版本累加1)
     */
    @Version
    @TableField(value = "version", fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    private Long version;

    /**
     * 删除标志( Y：已删除，N：未删除)
     */
    @TableLogic
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    private String deleted;

    /**
     * 创建人的ID
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    @Length(min = 1, max = 32, message = "长度不正确 创建人IDcreatedBy 1~32")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    private Date createTime;

    /**
     * 修改人的ID
     */
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    @Length(min = 1, max = 32, message = "长度不正确 创建人IDupdatedBy 1~32")
    private String updateBy;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(hidden = true)
    private Date updateTime;

}
