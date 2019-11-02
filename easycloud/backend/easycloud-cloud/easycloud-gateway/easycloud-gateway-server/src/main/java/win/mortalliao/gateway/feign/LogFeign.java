package win.mortalliao.gateway.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-07-01 15:16
 */
@FeignClient("ace-admin")
public interface LogFeign {
//  @RequestMapping(value="/api/log/save",method = RequestMethod.POST)
//  public void saveLog(LogInfo info);
}
