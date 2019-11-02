package win.mortalliao.auth.server.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import win.mortalliao.auth.common.exception.ClientInvalidException;
import win.mortalliao.auth.common.jwt.JwtClient;
import win.mortalliao.auth.server.entity.Client;
import win.mortalliao.auth.server.mapper.ClientMapper;
import win.mortalliao.auth.server.service.ClientService;
import win.mortalliao.auth.server.util.ClientTokenUtil;
import win.mortalliao.auth.server.util.UUIDUtils;
import win.mortalliao.starter.common.service.impl.BaseServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author mortal
 */
@Service
public class ClientServiceImpl extends BaseServiceImpl<ClientMapper, Client> implements ClientService {

    @Autowired
    private ClientTokenUtil clientTokenUtil;

    @Autowired
    private DiscoveryClient discovery;

    @Override
    public String apply(String clientId, String secret) {
        Client client = getClient(clientId, secret);
        return clientTokenUtil.generateToken(new JwtClient(client.getId().toString(), client.getClientId(), client.getName()));
    }

    private Client getClient(String clientId, String secret) {
        Client client = new Client();
        client.setClientId(clientId);
        client = mapper.selectOne(client);
        if (client == null || !client.getSecret().equals(secret)) {
            throw new ClientInvalidException("Client not found or Client secret is error!");
        }
        return client;
    }

    @Override
    public List<String> getAllowedClient(String clientId, String secret) {
        Client info = this.getClient(clientId, secret);
        List<String> clients = mapper.selectAllowedClient(info.getId() + "");
        return Optional.ofNullable(clients).orElse(Collections.emptyList());
    }

    @Override
    @Scheduled(cron = "0 0/1 * * * ?")
    public void registryClient() {
        // 自动注册节点
        discovery.getServices().forEach((name) -> {
            Client client = new Client();
            client.setName(name);
            client.setClientId(name);
            if (mapper.selectCount(new EntityWrapper<>(client)) == 0) {
                client.setSecret(UUIDUtils.generateShortUuid());
                mapper.insert(client);
            }
        });
    }
}
