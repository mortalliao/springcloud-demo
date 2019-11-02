package win.mortalliao.auth.client.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import win.mortalliao.auth.client.annotation.IgnoreClientToken;
import win.mortalliao.auth.client.config.ServiceAuthConfig;
import win.mortalliao.auth.client.helper.ServiceAuthHelper;
import win.mortalliao.auth.common.exception.ClientForbiddenException;
import win.mortalliao.auth.common.jwt.JwtInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

/**
 * @author mortal
 */
public class ServiceAuthRestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ServiceAuthHelper serviceAuthHelper;

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;

    private List<String> allowedClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 配置该注解，说明不进行服务拦截
        IgnoreClientToken annotation = Optional.ofNullable(handlerMethod.getBeanType().getAnnotation(IgnoreClientToken.class))
                .orElse(handlerMethod.getMethodAnnotation(IgnoreClientToken.class));
        if (annotation != null) {
            return super.preHandle(request, response, handler);
        }

        String token = request.getHeader(serviceAuthConfig.getTokenHeader());
        JwtInfo infoFromToken = serviceAuthHelper.getInfoFromToken(token);
        String uniqueName = infoFromToken.getUniqueName();
        for (String client : serviceAuthHelper.getAllowedClient()) {
            if (client.equals(uniqueName)) {
                return super.preHandle(request, response, handler);
            }
        }
        throw new ClientForbiddenException("Client is Forbidden!");
    }
}
