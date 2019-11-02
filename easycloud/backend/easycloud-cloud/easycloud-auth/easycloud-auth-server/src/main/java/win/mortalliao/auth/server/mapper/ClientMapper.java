package win.mortalliao.auth.server.mapper;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import win.mortalliao.auth.server.entity.Client;
import win.mortalliao.starter.common.repository.SuperMapper;

import java.util.List;

/**
 * client Mapper 接口
 *
 * @author mortal
 */
public interface ClientMapper extends SuperMapper<Client> {

    /**
     * 查询所有允许访问的客户端
     *
     * @param serviceId 服务id
     * @return List<String> 所有允许的客户端
     */
    @Select(" SELECT client.CODE FROM gate_client client" +
            " INNER JOIN gate_client_service gcs ON gcs.client_id = client.id " +
            " WHERE gcs.service_id = #{serviceId}")
    @ResultType(String.class)
    List<String> selectAllowedClient(String serviceId);

}
