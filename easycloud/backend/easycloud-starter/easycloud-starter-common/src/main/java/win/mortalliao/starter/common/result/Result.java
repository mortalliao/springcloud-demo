package win.mortalliao.starter.common.result;

import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import win.mortalliao.starter.common.constant.GlobalConstant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author mortal
 * isXxx 判断状态码
 * getXxx 根据key获取data中value，转换类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Result {
    /**
     * 状态码
     */
    @ApiModelProperty("状态码，0表示操作成功，1表示操作失败，-1表示系统错误")
    private Integer status = ResultEnum.SUCCESS.getStatus();

    /**
     * 提示信息
     */
    @ApiModelProperty("提示信息")
    private String message = ResultEnum.SUCCESS.getMessage();

    /**
     * 返回数据
     */
    @ApiModelProperty("返回数据")
    private Object data;

    /**
     * 返回分页对象
     **/
    @ApiModelProperty("分页信息")
    private PageInfo pageInfo;

    public Result(Page page) {
        this(page.getRecords());
        this.pageInfo = new PageInfo(page.getCurrent(), page.getSize(), page.getTotal(), page.getPages());
    }

    public Result(Object data, PageInfo pageInfo) {
        this(data);
        this.pageInfo = pageInfo;
    }

    public Result(ResultEnum resultEnum) {
        this.status = resultEnum.getStatus();
        this.message = resultEnum.getMessage();
    }

    public Result(ResultEnum resultEnum, Object data) {
        this.status = resultEnum.getStatus();
        this.message = resultEnum.getMessage();
        this.data = data;
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.status = code;
        this.message = message;
    }

    /**
     * 是否操作成功
     *
     * @return Boolean
     */
    @JsonIgnore
    public Boolean isSuccess() {
        return status.equals(ResultEnum.SUCCESS.getStatus());
    }

    /**
     * 是否操作失败
     *
     * @return Boolean
     */
    @JsonIgnore
    public Boolean isFail() {
        return status.equals(ResultEnum.FAIL.getStatus());
    }

    /**
     * 是否系统异常
     *
     * @return Boolean
     */
    @JsonIgnore
    public Boolean isError() {
        return status.equals(ResultEnum.ERROR.getStatus());
    }

    /**
     * 远程调用后原来是实体对象的data将转换成LinkedHashMap类型
     *
     * @return LinkedHashMap
     */
    public LinkedHashMap dataMap() {
        return (data != null && data instanceof LinkedHashMap) ? (LinkedHashMap) data : null;
    }

    /**
     * 远程调用后原来是分页对象的data将转换成ArrayList类型，list中的实体对象是LinkedHashMap
     *
     * @return ArrayList
     */
    public ArrayList dataList() {
        return (data != null && data instanceof ArrayList) ? (ArrayList) data : null;
    }

    /**
     * data转换成LinkedHashMap后，根据key获取value，返回Object类型
     *
     * @param key data转换成LinkedHashMap后中的key值
     * @return Object
     */
    public Object getObject(String key) {
        return getObject(dataMap(), key);
    }

    public static Object getObject(LinkedHashMap map, String key) {
        return Optional.ofNullable(map).map(data -> data.get(key)).orElse(null);
    }

    /**
     * data转换成LinkedHashMap后，根据key获取value，返回List类型
     * 注意：如果类型不对，将返回null
     *
     * @param key data转换成LinkedHashMap后中的key值
     * @return String
     */
    public List getList(String key) {
        return getList(dataMap(), key);
    }

    public static List getList(LinkedHashMap map, String key) {
        Object object = getObject(map, key);
        return (object != null && object instanceof List) ? (List) object : null;
    }

    /**
     * data转换成LinkedHashMap后，根据key获取value，返回Map类型
     * 注意：如果类型不对，将返回null
     *
     * @param key data转换成LinkedHashMap后中的key值
     * @return LinkedHashMap
     */
    public LinkedHashMap getMap(String key) {
        return getMap(dataMap(), key);
    }

    public static LinkedHashMap getMap(LinkedHashMap map, String key) {
        Object object = getObject(map, key);
        return (object != null && object instanceof LinkedHashMap) ? (LinkedHashMap) object : null;
    }

    /**
     * data转换成LinkedHashMap后，根据key获取value，返回Date类型
     * 注意：如果类型不对，将返回null
     *
     * @param key data转换成LinkedHashMap后中的key值
     * @return Date
     */
    public Date getDate(String key) {
        return getDate(dataMap(), key, GlobalConstant.DEFAULT_DATE_PATTERN);
    }

    public static Date getDate(LinkedHashMap map, String key, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateString = getString(map, key);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            log.error("日期解析异常 pattern:" + pattern + " string:" + dateString, e);
        }
        return date;
    }

    /**
     * data转换成LinkedHashMap后，根据key获取value，返回String类型
     * 注意：如果类型不对，将返回null
     *
     * @param key data转换成LinkedHashMap后中的key值
     * @return String
     */
    public String getString(String key) {
        return getString(dataMap(), key);
    }

    public static String getString(LinkedHashMap map, String key) {
        Object object = getObject(map, key);
        return (object != null && object instanceof String) ? object.toString() : null;
    }

    /**
     * data转换成LinkedHashMap后，根据key获取value，返回Integer类型
     * 注意：如果类型不对，将返回null
     *
     * @param key data转换成LinkedHashMap后中的key值
     * @return Integer
     */
    public Integer getInteger(String key) {
        return getInteger(dataMap(), key);
    }

    public static Integer getInteger(LinkedHashMap map, String key) {
        Object object = getObject(map, key);
        return (object != null && object instanceof Integer) ? (Integer) object : null;
    }

    /**
     * data转换成LinkedHashMap后，根据key获取value，返回Long类型
     * 注意：如果类型不对，将返回null
     *
     * @param key data转换成LinkedHashMap后中的key值
     * @return Long
     */
    public Long getLong(String key) {
        return getLong(dataMap(), key);
    }

    public static Long getLong(LinkedHashMap map, String key) {
        Object object = getObject(map, key);
        return (object != null && object instanceof Long) ? (Long) object : null;
    }

    /**
     * data转换成LinkedHashMap后，根据key获取value，返回Double类型
     * 注意：如果类型不对，将返回null
     *
     * @param key data转换成LinkedHashMap后中的key值
     * @return Double
     */
    public Double getDouble(String key) {
        return getDouble(dataMap(), key);
    }

    public static Double getDouble(LinkedHashMap map, String key) {
        Object object = getObject(map, key);
        return (object != null && object instanceof Double) ? (Double) object : null;
    }

    /**
     * data转换成LinkedHashMap后，根据key获取value，返回Boolean类型
     * 注意：如果类型不对，将返回null
     *
     * @param key data转换成LinkedHashMap后中的key值
     * @return Boolean
     */
    public Boolean getBoolean(String key) {
        return getBoolean(dataMap(), key);
    }

    public static Boolean getBoolean(LinkedHashMap map, String key) {
        Object object = getObject(map, key);
        return (object != null && object instanceof Boolean) ? (Boolean) object : null;
    }

    /**
     * 分页信息对象
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel(description = "分页信息")
    public static class PageInfo {
        /**
         * 当前页
         */
        @ApiModelProperty("当前页")
        protected int currentPage;

        /**
         * 一页显示多少记录
         */
        @ApiModelProperty("页大小")
        protected int pageSize;

        /**
         * 总记录数
         */
        @ApiModelProperty("总记录数")
        protected long totalCount;

        /**
         * 总页数
         */
        @ApiModelProperty("总页数")
        protected long totalPage;
    }

    public int currentPage() {
        return pageInfo.getCurrentPage();
    }

    public int pageSize() {
        return pageInfo.getPageSize();
    }

    public long totalCount() {
        return pageInfo.getTotalCount();
    }

    public long totalPage() {
        return pageInfo.getTotalPage();
    }

}
