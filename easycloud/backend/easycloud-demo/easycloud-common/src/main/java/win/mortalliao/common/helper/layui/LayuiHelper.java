package win.mortalliao.common.helper.layui;

import com.baomidou.mybatisplus.plugins.Page;
import win.mortalliao.common.entity.Result;
import win.mortalliao.common.enums.ResultEnum;

import java.util.List;

/**
 *
 */
public class LayuiHelper {

    public static Table<Object> table(Integer count, List<Object> data) {
        return new Table<Object>(0, count, data);
    }

    @SuppressWarnings("unchecked")
    public static Table<Object> table(Result result) {
        if (result.getCode().equals(ResultEnum.SUCCESS.getCode())) {
            List<Object> data = (List<Object>) result.getData();
            return new Table<Object>(result.getCode(), ((Page) result.getData()).getTotal(), data);
        }
        return null;
    }
}
