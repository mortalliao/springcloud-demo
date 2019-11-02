package win.mortalliao.starter.common.constant;

/**
 * @author liaoyujian
 * 分页、收索条件 常量
 */
public class PageSearchConstant {

    /**
     * 等于
     */
    public static final String SEARCH_EQ = "_eq";

    /**
     * 左模糊
     */
    public static final String SEARCH_LLIKE = "_llike";

    /**
     * 右模糊
     */
    public static final String SEARCH_RLIKE = "_rlike";

    /**
     * 全模糊
     */
    public static final String SEARCH_LIKE = "_like";

    /**
     * 等同于SQL的"field<value"表达式
     */
    public static final String SEARCH_LT = "_lt";

    /**
     * 等同于SQL的"field<=value"表达式
     */
    public static final String SEARCH_LE = "_le";

    /**
     * 等同于SQL的"field>value"表达式
     */
    public static final String SEARCH_GT = "_gt";

    /**
     * 等同于SQL的"field>=value"表达式
     */
    public static final String SEARCH_GE = "_ge";
}
