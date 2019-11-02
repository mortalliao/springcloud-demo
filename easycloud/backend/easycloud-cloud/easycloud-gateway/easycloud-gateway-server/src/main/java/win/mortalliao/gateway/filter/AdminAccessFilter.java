package win.mortalliao.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import win.mortalliao.auth.client.config.ServiceAuthConfig;
import win.mortalliao.auth.client.config.UserAuthConfig;
import win.mortalliao.auth.client.context.UserContext;
import win.mortalliao.auth.client.exception.JwtIllegalArgumentException;
import win.mortalliao.auth.client.exception.JwtSignatureException;
import win.mortalliao.auth.client.exception.JwtTokenExpiredException;
import win.mortalliao.auth.client.helper.ServiceAuthHelper;
import win.mortalliao.auth.client.helper.UserAuthHelper;
import win.mortalliao.auth.client.result.AuthResultEnum;
import win.mortalliao.auth.common.jwt.JwtInfo;
import win.mortalliao.auth.common.vo.PermissionInfo;
import win.mortalliao.gateway.feign.UserFeign;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author mortal
 */
@Component
@Slf4j
public class AdminAccessFilter extends ZuulFilter {

    @Value("${gate.ignore.startWith}")
    private String startWith;

    @Value("${zuul.prefix}")
    private String zuulPrefix;

    @Autowired
    UserFeign userFeign;

    @Autowired
    UserAuthConfig userAuthConfig;

    @Autowired
    UserAuthHelper userAuthHelper;

    @Autowired
    ServiceAuthConfig serviceAuthConfig;

    @Autowired
    ServiceAuthHelper serviceAuthHelper;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        final String requestUri = request.getRequestURI().substring(zuulPrefix.length());
        final String method = request.getMethod();
        UserContext.setToken(null);
        // 不进行拦截的地址
        if (isStartWith(requestUri)) {
            return null;
        }
        // 获取用户信息
        JwtInfo jwtUser = null;
        try {
            jwtUser = getJwtUser(request, requestContext);
        } catch (JwtIllegalArgumentException e) {
            setFailedRequest(AuthResultEnum.AUTH_TOKEN_ILLEGAL);
            return null;
        } catch (JwtTokenExpiredException e) {
            setFailedRequest(AuthResultEnum.AUTH_TOKEN_EXPIRED);
            return null;
        } catch (JwtSignatureException e) {
            setFailedRequest(AuthResultEnum.AUTH_TOKEN_SIGNATURE_ERROR);
            return null;
        }

        List<PermissionInfo> allPermissionInfo = userFeign.getAllPermissionInfo();
        // 判断资源是否启用权限约束
        if (inPermissions(requestUri, method, allPermissionInfo)) {
            String username = jwtUser.getName();
            List<PermissionInfo> permissionInfos = getUserPermission(requestContext.getRequest(), username);
            List<PermissionInfo> permissions = getIncludePermissions(requestUri, method, permissionInfos);
            if (permissions != null && !permissions.isEmpty()) {
                permissionInfos.forEach(permissionInfo -> {
                    if (!HttpMethod.GET.matches(permissionInfo.getMethod())) {
                        setCurrentUserInfoAndLog(requestContext, username, permissionInfo);
                    }
                });
            } else {
                setFailedRequest(AuthResultEnum.AUTH_TOKEN_ERROR);
            }
        }
        // 申请客户端密钥
        requestContext.addZuulRequestHeader(serviceAuthConfig.getTokenHeader(), serviceAuthHelper.getClientToken());
        UserContext.remove();
        return null;
    }

    /**
     * 返回token中的用户信息
     *
     * @param request        request
     * @param requestContext requestContext
     * @return JwtInfo
     */
    private JwtInfo getJwtUser(HttpServletRequest request, RequestContext requestContext) throws JwtIllegalArgumentException, JwtTokenExpiredException, JwtSignatureException {
        String authToken = request.getHeader(userAuthConfig.getTokenHeader());
        if (StringUtils.isBlank(authToken)) {
            authToken = request.getParameter("token");
        }
        requestContext.addZuulRequestHeader(userAuthConfig.getTokenHeader(), authToken);
        UserContext.setToken(authToken);
        return userAuthHelper.getInfoFromToken(authToken);
    }

    /**
     * 权限列表permissionInfos中是否有匹配的requestUri
     *
     * @param requestUri      uri
     * @param method          method
     * @param permissionInfos permissionInfos
     * @return Boolean
     */
    private Boolean inPermissions(final String requestUri, final String method, List<PermissionInfo> permissionInfos) {
        return getIncludePermissions(requestUri, method, permissionInfos).size() > 0;
    }

    private List<PermissionInfo> getIncludePermissions(final String requestUri, final String method, List<PermissionInfo> permissionInfos) {
        return permissionInfos.stream().filter(permissionInfo -> {
            String url = permissionInfo.getUri();
            String uri = url.replaceAll("\\{\\*\\}", "[a-zA-Z\\\\d]+");
            String regEx = "^" + uri + "$";
            return (Pattern.compile(regEx).matcher(requestUri).find() || requestUri.startsWith(url + "/"))
                    && method.equals(permissionInfo.getMethod());
        }).collect(Collectors.toList());
    }

    /**
     * 获取用户的所有权限
     *
     * @param request  request
     * @param username username
     * @return List<PermissionInfo>
     */
    private List<PermissionInfo> getUserPermission(HttpServletRequest request, String username) {
        return Optional.ofNullable(request.getSession().getAttribute("permission"))
                .map(o -> {
                    if (o instanceof List) {
                        return (List<PermissionInfo>) o;
                    }
                    return null;
                })
                .orElseGet(() -> {
                    List<PermissionInfo> permissionInfos = userFeign.getPermissionByUsername(username);
                    request.getSession().setAttribute("permission", permissionInfos);
                    return permissionInfos;
                });
    }

    private void setCurrentUserInfoAndLog(RequestContext requestContext, String username, PermissionInfo pm) {
//        UserInfo info = userFeign.getUserByUsername(username);
//        String host = ClientUtil.getClientIp(requestContext.getRequest());
//        requestContext.addZuulRequestHeader("userId", info.getId());
//        requestContext.addZuulRequestHeader("userName", URLEncoder.encode(info.getName()));
//        requestContext.addZuulRequestHeader("userHost", ClientUtil.getClientIp(requestContext.getRequest()));
//        LogInfo logInfo = new LogInfo(pm.getMenu(), pm.getName(), pm.getUri(), new Date(), info.getId(), info.getName(), host);
//        DBLog.getInstance().setLogService(logService).offerQueue(logInfo);
    }

    /**
     * URI是否以什么打头
     *
     * @param requestUri URI
     * @return boolean
     */
    private boolean isStartWith(String requestUri) {
        for (String s : startWith.split(",")) {
            if (requestUri.startsWith(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 网关抛异常，用户鉴权失败
     */
    private void setFailedRequest(AuthResultEnum resultEnum) {
        ObjectMapper objectMapper = new ObjectMapper();
        String body = "";
        try {
            body = objectMapper.writeValueAsString(resultEnum);
        } catch (JsonProcessingException e) {
            log.error("This never gonna happened!" + e.getMessage(), e);
        }
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.setResponseStatusCode(200);
        if (requestContext.getResponseBody() == null) {
            requestContext.setResponseBody(body);
            requestContext.setSendZuulResponse(false);
        }
    }
}
