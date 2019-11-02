package win.mortalliao.auth.client.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import win.mortalliao.auth.client.annotation.IgnoreUserToken;
import win.mortalliao.auth.client.config.UserAuthConfig;
import win.mortalliao.auth.client.context.UserContext;
import win.mortalliao.auth.client.helper.UserAuthHelper;
import win.mortalliao.auth.common.jwt.JwtInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @author mortal
 */
@Slf4j
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserAuthHelper userAuthHelper;

    @Autowired
    private UserAuthConfig userAuthConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 配置该注解，说明不进行用户拦截
        IgnoreUserToken annotation = Optional.ofNullable(handlerMethod.getBeanType().getAnnotation(IgnoreUserToken.class))
                .orElse(handlerMethod.getMethodAnnotation(IgnoreUserToken.class));
        if (annotation != null) {
            return super.preHandle(request, response, handler);
        }

        String token = request.getHeader(userAuthConfig.getTokenHeader());
        JwtInfo infoFromToken = userAuthHelper.getInfoFromToken(token);
        UserContext.setUsername(infoFromToken.getUniqueName());
        UserContext.setName(infoFromToken.getName());
        UserContext.setUserID(infoFromToken.getId());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
