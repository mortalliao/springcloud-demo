package win.mortalliao.auth.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.auth.server.service.ClientService;

import java.util.List;

/**
 * @author mortal
 */
@RestController
@RequestMapping("client")
@Api(description = "服务对服务鉴权", tags = "服务对服务鉴权")
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * 获取客户端token
     *
     * @param clientId 客户端Id
     * @param secret   客户端密钥
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取服务token", notes = "如果需要访问其他服务，请先获取服务token")
    @PostMapping("/token")
    public ResponseEntity getAccessToken(String clientId, String secret) throws Exception {
        String apply = clientService.apply(clientId, secret);
        return ResponseEntity.ok(apply);
    }

    /**
     * 获取允许访问的客户端列表
     *
     * @param serviceId
     * @param secret
     * @return
     */
    @GetMapping("/myClient")
    @ApiOperation("获取允许访问服务的客户端列表")
    public ResponseEntity getAllowedClient(String serviceId, String secret) {
        List<String> allowedClients = clientService.getAllowedClient(serviceId, secret);
        return ResponseEntity.ok(allowedClients);
    }

}
