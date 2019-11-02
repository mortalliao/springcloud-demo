package win.mortalliao.test.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;
import win.mortalliao.starter.common.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试表
 *
 * @author liaoyuajin
 * @since 2017-11-16
 */
@Document(indexName = "test_index", type = "test", indexStoreType = "fs", shards = 5, replicas = 1, refreshInterval = "-1")
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Test extends BaseEntity<Test> {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId("id")
    @ApiModelProperty(hidden = true)
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;

    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String address;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Integer sex;

    /**
     * 生日
     */
    @TableField("birthday_dt")
    @ApiModelProperty("生日")
    private Date birthdayDt;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 分数
     */
    @ApiModelProperty("分数")
    private Double score;

    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String SEX = "sex";
    public static final String BIRTHDAY_DT = "birthday_dt";
    public static final String MOBILE = "mobile";
    public static final String SCORE = "score";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
