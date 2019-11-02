package com.gzedu.ecloud.testa.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.gzedu.ecloud.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liaoyuajin
 * @since 2017-11-17
 */
@TableName("test_a")
@Data
@Accessors(chain = true)
public class TestA extends BaseEntity<TestA> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "test_id", type= IdType.UUID)
    @ApiModelProperty("")
    private String testId;

    @ApiModelProperty("")
    private String name;

    @ApiModelProperty("")
    private String address;

    @ApiModelProperty("")
    private Integer sex;

    @TableField("birthday_dt")
    @ApiModelProperty("")
    private Date birthdayDt;

    @ApiModelProperty("")
    private String mobile;

    @ApiModelProperty("")
    private Integer score;

    public static final String TEST_ID = "test_id";
    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String SEX = "sex";
    public static final String BIRTHDAY_DT = "birthday_dt";
    public static final String MOBILE = "mobile";
    public static final String SCORE = "score";

    @Override
    protected Serializable pkVal() {
        return this.testId;
    }

}
