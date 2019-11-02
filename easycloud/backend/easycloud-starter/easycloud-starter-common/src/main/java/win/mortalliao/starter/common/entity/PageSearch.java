package win.mortalliao.starter.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * @author mortal
 * 分页搜索条件
 */
@ApiModel
@Data
public class PageSearch {

    /**
     * 搜索条件
     */
    @ApiModelProperty(value = "搜索条件", position = 1)
    private Map<String, Object> where;

    /**
     * 排序条件
     */
    @ApiModelProperty(value = "排序条件", position = 2)
    private Map<String, String> orderBy;

}
