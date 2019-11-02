package win.mortalliao.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import win.mortalliao.admin.entity.SuperEntity;
import win.mortalliao.admin.service.SuperService;
import win.mortalliao.admin.utils.StringEscapeEditor;
import win.mortalliao.common.entity.Result;
import win.mortalliao.common.utils.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mortalliao
 * Description:
 */
@Slf4j
public class SuperController<T extends SuperEntity<T>> {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //自动转换日期类型的字段格式
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));

        //防止XSS攻击
        binder.registerCustomEditor(String.class, new StringEscapeEditor());
    }

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    protected String redirectTo(String url) {
        return new StringBuffer("redirect:").append(url).toString();
    }

    @Autowired
    private SuperService<T> superService;

    // 单资源
    @ApiOperation(value = "保存 单资源", notes = "保存单资源，返回保存的数据")
    @PostMapping("/")
    public Result save(@RequestBody @Valid T entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }

        if (superService.create(entity)) {
            return ResultUtil.success(entity);
        }
        return ResultUtil.error("保存失败");
    }

    // 单资源带id
    @ApiOperation(value = "获取 单资源带id")
    @GetMapping("/{id}")
    public Result get(@PathVariable("id") Long id) {
        T entity = superService.selectById(id);
        if (entity != null) {
            return ResultUtil.success(entity);
        }
        return ResultUtil.error("id为" + id + "的资源不存在");
    }

    @ApiOperation(value = "删除 单资源带id")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Long id) {
        if (superService.deleteById(id)) {
            return ResultUtil.success();
        }
        return ResultUtil.error("删除失败");
    }

    @ApiOperation(value = "更新 单资源带id")
    @PutMapping("/{id}")
    public Result update(@PathVariable("id") Long id, @RequestBody T entity) {
        T selectEntity = superService.selectById(id);
        if (selectEntity == null) {
            return ResultUtil.error("id为" + selectEntity.getId() + "的资源不存在");
        }

        if (superService.update(id, selectEntity.getVersion(), entity)) {
            return ResultUtil.success(entity);
        }
        return ResultUtil.error("更新失败");
    }

    // 多资源
    @ApiOperation(value = "获取 多资源 分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = false, dataType = "Integer")
    })
    @GetMapping("/")
    public Result list(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<T> entityPage = superService.selectPage(new Page<T>(currentPage, pageSize), new EntityWrapper<T>()
                .orderBy("update_time", false));
        return ResultUtil.success(entityPage);
    }

}