package win.mortalliao.starter.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * @author mortal
 * 抽象父类实体，包含六个基本字段
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public abstract class BaseEntity<T extends Model> extends Model<T> {

    /**
     * 数据版本(修改一版本累加1)
     */
    @Version
    @TableField(value = "version", fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    protected Long version;

    /**
     * 删除标志( Y：已删除，N：未删除)
     */
    @TableLogic
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    protected String isDeleted;

    /**
     * 创建人的ID
     */
    @TableField(value = "created_by", fill = FieldFill.INSERT)
    @Length(min = 1, max = 64, message = "长度不正确 创建人ID createdBy 1~64")
    @ApiModelProperty("创建人ID")
    protected String createdBy;

    /**
     * 创建时间
     */
    @TableField(value = "created_dt", fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    protected Date createdDt;

    /**
     * 修改人的ID
     */
    @TableField(value = "updated_by", fill = FieldFill.INSERT_UPDATE)
    @Length(min = 1, max = 64, message = "长度不正确 修改人ID updatedBy 1~64")
    @ApiModelProperty("修改人ID")
    protected String updatedBy;

    /**
     * 修改时间
     */
    @TableField(value = "updated_dt", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(hidden = true)
    protected Date updatedDt;

    public static final String VERSION = "version";
    public static final String IS_DELETED = "is_deleted";
    public static final String CREATED_BY = "created_by";
    public static final String CREATED_DT = "created_dt";
    public static final String UPDATED_BY = "updated_by";
    public static final String UPDATED_DT = "updated_dt";

}
