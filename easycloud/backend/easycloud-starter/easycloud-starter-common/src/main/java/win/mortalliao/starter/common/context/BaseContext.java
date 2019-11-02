package win.mortalliao.starter.common.context;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liaoyujian
 */
class BaseContext {

    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>(16);
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>(16);
            threadLocal.set(map);
        }
        return map.get(key);
    }

    static void remove() {
        threadLocal.remove();
    }

    static String returnObjectValue(Object value) {
        return value == null ? null : value.toString();
    }

}
