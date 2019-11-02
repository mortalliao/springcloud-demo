package win.mortalliao.jwt.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import win.mortalliao.jwt.serializer.JsonIgnoreSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mortalliao
 */
@TableName("LMS_USER")
@Data
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("USER_ID")
    private String userId;

    /**
     * 登录用户名
     */
    @TableField("USER_CODE")
    private String userCode;

    /**
     * 登录密码
     */
    @TableField("PASSWOR")
    @JsonSerialize(using = JsonIgnoreSerializer.class)
    private String passwor;

    /**
     * 单位代码
     */
    @TableField("DEPT_CODE")
    private String deptCode;

    /**
     * 用户类型 1 网络课程学员 2 网络研修学员
     */
    @TableField("USER_TYPE")
    private String userType;

    /**
     * 学号(唯一编码)
     */
    @TableField("TEACHER_ID")
    private String teacherId;

    /**
     * EE号
     */
    @TableField("EE_NUMBER")
    private String eeNumber;

    /**
     * 真实姓名
     */
    @TableField("REALNAME")
    private String realname;

    /**
     * 性别，见sys_data表数据
     */
    @TableField("SEX")
    private String sex;

    /**
     * 出生日期
     */
    @TableField("BORN_DT")
    private Date bornDt;

    /**
     * 证件号码
     */
    @TableField("PAPERS_NUMBER")
    private String papersNumber;

    /**
     * 证件类型(使用代码)
     */
    @TableField("PAPERS_TYPE")
    private String papersType;

    /**
     * 密码问题
     */
    @TableField("PWD_QUESTION")
    private String pwdQuestion;

    /**
     * 密码答案
     */
    @TableField("PWD_ANSWER")
    private String pwdAnswer;

    /**
     * 民族(使用代码)
     */
    @TableField("NATION")
    private String nation;

    /**
     * 政治面貌(使用代码)
     */
    @TableField("POLITICS_ROLE")
    private String politicsRole;

    /**
     * 籍贯所在省(使用代码)
     */
    @TableField("BORN_PROVINCE")
    private String bornProvince;

    /**
     * 籍贯所在市/区(填写)
     */
    @TableField("BORN_CITY")
    private String bornCity;

    /**
     * 婚姻状况,1 未婚 2 已婚
     */
    @TableField("MARITAL_STATUS")
    private String maritalStatus;

    /**
     * 手机
     */
    @TableField("MOBILE_PHONE")
    private String mobilePhone;

    /**
     * 办公电话
     */
    @TableField("OFFICE_PHONE")
    private String officePhone;

    /**
     * 家庭电话
     */
    @TableField("HOME_PHONE")
    private String homePhone;

    /**
     * 电子邮件，可用作取回密码用
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 现在住址
     */
    @TableField("HOME_ADDRESS")
    private String homeAddress;

    /**
     * 通信地址
     */
    @TableField("CORR_ADDRESS")
    private String corrAddress;

    /**
     * 邮政编码
     */
    @TableField("POST_CODE")
    private String postCode;

    /**
     * 参加工作年月
     */
    @TableField("WORK_DT")
    private Date workDt;

    /**
     * 从教时间
     */
    @TableField("ENGAGE_DT")
    private Date engageDt;

    /**
     * 个人主页
     */
    @TableField("HOME_PAGE")
    private String homePage;

    /**
     * 照片地址
     */
    @TableField("PHOTO_PATH")
    private String photoPath;

    /**
     * 自我介绍
     */
    @TableField("SELFHOOD")
    private String selfhood;

    /**
     * 在岗信息 1 在职 2 临聘 3 退休 4 离职
     */
    @TableField("POST_TYPE")
    private String postType;

    /**
     * 退休日期
     */
    @TableField("RETIRED_DT")
    private Date retiredDt;

    /**
     * 审批状态 0： 未提交 1：已提交，未审核 2：审核通过 3：重新填写 4:未更新 5:已归档
     */
    @TableField("AUDIT_STATUS")
    private String auditStatus;

    /**
     * 审批时间
     */
    @TableField("AUDITE_DT")
    private Date auditeDt;

    /**
     * 审批人
     */
    @TableField("AUDITOR")
    private String auditor;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    @TableField("UPDATED_DT")
    private Date updatedDt;

    /**
     * 修改人的id
     */
    @TableField("UPDATED_BY")
    private String updatedBy;

    @TableField("CREATED_DT")
    private Date createdDt;

    /**
     * 创建人的id
     */
    @TableField("CREATED_BY")
    private String createdBy;

    /**
     * 删除标志， Y或N
     */
    @TableField("ISDELETED")
    private String isdeleted;

    @TableField("VERSION")
    private String version;

    @TableField("ORIGIN")
    private String origin;

    @TableField("VERIFY_CODE")
    private String verifyCode;

    /**
     * 个人主页访问量
     */
    @TableField("VISIT_CNT")
    private String visitCnt;

    /**
     * 是否同步微课程，Y或N
     */
    @TableField("IS_SYNC")
    private String isSync;

    /**
     * 学科学段
     */
    @TableField("SUB_ID")
    private String subId;

    /**
     * 籍贯所在区
     */
    @TableField("BORN_AREA")
    private String bornArea;

    /**
     * 登录次数
     */
    @TableField("LOGIN_TIMES")
    private String loginTimes;

    /**
     * 学科代码
     */
    @TableField("SUB_CODE")
    private String subCode;

    /**
     * 学段代码
     */
    @TableField("SECTION_CODE")
    private String sectionCode;

    /**
     * 学历，性别，见sys_data表数据
     */
    @TableField("DEGREE")
    private String degree;

    /**
     * 应用ID
     */
    @TableField("APP_ID")
    private String appId;

    @TableField("SKIN_COLOR")
    private String skinColor;

    /**
     * 外部USER_ID，临时使用
     */
    @TableField("OUT_USER_ID")
    private String outUserId;

    /**
     * 错误登录次数
     */
    @TableField("ERROR_LOGIN_CNT")
    private String errorLoginCnt;

    public static final String USER_ID = "USER_ID";
    public static final String USER_CODE = "USER_CODE";
    public static final String PASSWOR = "PASSWOR";
    public static final String DEPT_CODE = "DEPT_CODE";
    public static final String USER_TYPE = "USER_TYPE";
    public static final String TEACHER_ID = "TEACHER_ID";
    public static final String EE_NUMBER = "EE_NUMBER";
    public static final String REALNAME = "REALNAME";
    public static final String SEX = "SEX";
    public static final String BORN_DT = "BORN_DT";
    public static final String PAPERS_NUMBER = "PAPERS_NUMBER";
    public static final String PAPERS_TYPE = "PAPERS_TYPE";
    public static final String PWD_QUESTION = "PWD_QUESTION";
    public static final String PWD_ANSWER = "PWD_ANSWER";
    public static final String NATION = "NATION";
    public static final String POLITICS_ROLE = "POLITICS_ROLE";
    public static final String BORN_PROVINCE = "BORN_PROVINCE";
    public static final String BORN_CITY = "BORN_CITY";
    public static final String MARITAL_STATUS = "MARITAL_STATUS";
    public static final String MOBILE_PHONE = "MOBILE_PHONE";
    public static final String OFFICE_PHONE = "OFFICE_PHONE";
    public static final String HOME_PHONE = "HOME_PHONE";
    public static final String EMAIL = "EMAIL";
    public static final String HOME_ADDRESS = "HOME_ADDRESS";
    public static final String CORR_ADDRESS = "CORR_ADDRESS";
    public static final String POST_CODE = "POST_CODE";
    public static final String WORK_DT = "WORK_DT";
    public static final String ENGAGE_DT = "ENGAGE_DT";
    public static final String HOME_PAGE = "HOME_PAGE";
    public static final String PHOTO_PATH = "PHOTO_PATH";
    public static final String SELFHOOD = "SELFHOOD";
    public static final String POST_TYPE = "POST_TYPE";
    public static final String RETIRED_DT = "RETIRED_DT";
    public static final String AUDIT_STATUS = "AUDIT_STATUS";
    public static final String AUDITE_DT = "AUDITE_DT";
    public static final String AUDITOR = "AUDITOR";
    public static final String REMARK = "REMARK";
    public static final String UPDATED_DT = "UPDATED_DT";
    public static final String UPDATED_BY = "UPDATED_BY";
    public static final String CREATED_DT = "CREATED_DT";
    public static final String CREATED_BY = "CREATED_BY";
    public static final String ISDELETED = "ISDELETED";
    public static final String VERSION = "VERSION";
    public static final String ORIGIN = "ORIGIN";
    public static final String VERIFY_CODE = "VERIFY_CODE";
    public static final String VISIT_CNT = "VISIT_CNT";
    public static final String IS_SYNC = "IS_SYNC";
    public static final String SUB_ID = "SUB_ID";
    public static final String BORN_AREA = "BORN_AREA";
    public static final String LOGIN_TIMES = "LOGIN_TIMES";
    public static final String SUB_CODE = "SUB_CODE";
    public static final String SECTION_CODE = "SECTION_CODE";
    public static final String DEGREE = "DEGREE";
    public static final String APP_ID = "APP_ID";
    public static final String SKIN_COLOR = "SKIN_COLOR";
    public static final String OUT_USER_ID = "OUT_USER_ID";
    public static final String ERROR_LOGIN_CNT = "ERROR_LOGIN_CNT";

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
