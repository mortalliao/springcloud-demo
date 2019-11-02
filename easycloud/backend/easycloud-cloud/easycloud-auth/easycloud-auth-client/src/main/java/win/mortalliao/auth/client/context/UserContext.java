package win.mortalliao.auth.client.context;

import win.mortalliao.auth.common.constant.UserConstant;
import win.mortalliao.common.api.context.BaseContext;

import java.util.Optional;

/**
 * @author mortal
 */
public class UserContext extends BaseContext {

    public static String getUserID() {
        return Optional.ofNullable(get(UserConstant.CONTEXT_KEY_USER_ID)).map(Object::toString).orElse(null);
    }

    public static void setUserID(String userID) {
        set(UserConstant.CONTEXT_KEY_USER_ID, userID);
    }

    public static String getUsername() {
        return Optional.ofNullable(get(UserConstant.CONTEXT_KEY_USERNAME)).map(Object::toString).orElse(null);
    }

    public static void setUsername(String username) {
        set(UserConstant.CONTEXT_KEY_USERNAME, username);
    }

    public static String getName() {
        return Optional.ofNullable(get(UserConstant.CONTEXT_KEY_USER_NAME)).map(Object::toString).orElse(null);
    }

    public static void setName(String name) {
        set(UserConstant.CONTEXT_KEY_USER_NAME, name);
    }

    public static String getToken() {
        return Optional.ofNullable(get(UserConstant.CONTEXT_KEY_USER_TOKEN)).map(Object::toString).orElse(null);
    }

    public static void setToken(String token) {
        set(UserConstant.CONTEXT_KEY_USER_TOKEN, token);
    }

}
