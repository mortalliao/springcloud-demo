package win.mortalliao.auth.server.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import win.mortalliao.starter.common.entity.AutoIdEntity;

/**
 * @author mortal
 * 服务表
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName("system_gate_client")
public class Client extends AutoIdEntity<Client> {

    /**
     * clientId ，与服务名相同，相当于username
     */
    @TableField("client_id")
    private String clientId;

    /**
     * 一个shortUUID，相当于password
     */
    private String secret;

    /**
     * 服务名
     */
    private String name;

    /**
     * 服务描述
     */
    private String description;

    public static final String CLIENT_ID = "client_id";
    public static final String SECRET = "secret";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
}