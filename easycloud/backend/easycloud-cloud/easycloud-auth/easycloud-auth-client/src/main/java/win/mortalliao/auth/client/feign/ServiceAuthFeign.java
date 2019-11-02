package win.mortalliao.auth.client.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mortal
 */
@FeignClient(value = "${auth.serviceId}", configuration = {}, fallback = Void.class)
public interface ServiceAuthFeign {

    /**
     * 获取允许访问的客户端列表
     *
     * @param serviceId 服务ID
     * @param secret    服务的shortUUID
     * @return 客户端列表
     */
    @RequestMapping(value = "/client/myClient")
    public String[] getAllowedClient(@RequestParam("serviceId") String serviceId, @RequestParam("secret") String secret);


    /**
     * 获取访问客户端的令牌
     *
     * @param clientId clientId
     * @param secret   secret
     * @return token
     */
    @RequestMapping(value = "/client/token", method = RequestMethod.POST)
    public Object getAccessToken(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);

}
