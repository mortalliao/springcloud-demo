package win.mortalliao.starter.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author liaoyujian
 * 默认主键自增 父实体类
 */
@ApiModel
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class AutoIdEntity<T extends Model> extends BaseEntity<T> {

    /**
     * 主键ID
     */
    @TableId("id")
    @ApiModelProperty(hidden = true)
    protected Long id;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public static final String ID = "id";
}
