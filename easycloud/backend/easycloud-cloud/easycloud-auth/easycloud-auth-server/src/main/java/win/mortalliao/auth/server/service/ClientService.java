package win.mortalliao.auth.server.service;

import win.mortalliao.auth.server.entity.Client;
import win.mortalliao.starter.common.service.BaseService;

import java.util.List;

/**
 * @author mortal
 */
public interface ClientService extends BaseService<Client> {
    /**
     * 获取客户端token
     *
     * @param clientId 客户端Id
     * @param secret   客户端密钥
     * @return
     * @throws Exception
     */
    public String apply(String clientId, String secret);

    /**
     * 获取授权的客户端列表
     *
     * @param serviceId
     * @param secret
     * @return
     */
    public List<String> getAllowedClient(String serviceId, String secret);

    /**
     * 自动注册节点
     */
    public void registryClient();
}
