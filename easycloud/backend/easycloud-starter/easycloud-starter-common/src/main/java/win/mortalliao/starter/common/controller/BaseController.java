package win.mortalliao.starter.common.controller;

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
import win.mortalliao.starter.common.entity.BaseEntity;
import win.mortalliao.starter.common.entity.PageSearch;
import win.mortalliao.starter.common.result.Result;
import win.mortalliao.starter.common.result.ResultData;
import win.mortalliao.starter.common.service.BaseService;
import win.mortalliao.starter.common.util.StringEscapeEditor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mortalliao
 */
@Slf4j
public class BaseController<T extends BaseEntity<T>> {

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

    @Autowired
    private BaseService<T> baseService;

    /**
     * 保存 单资源
     *
     * @param entity        实体
     * @param bindingResult hibernate validator
     * @return Result
     */
    @ApiOperation(value = "保存 单资源", notes = "保存单资源，返回保存的数据")
    @PostMapping("/")
    public Result insert(@RequestBody @Valid T entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultData.fail(bindingResult.getFieldError().getDefaultMessage());
        }

        if (baseService.create(entity)) {
            return ResultData.success(entity);
        }
        return ResultData.fail("保存失败");
    }

    /**
     * 获取 单资源带id
     *
     * @param id id
     * @return Result
     */
    @ApiOperation(value = "获取 单资源带id")
    @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "path")
    @GetMapping("/{id}")
    public Result select(@PathVariable("id") Serializable id) {
        T entity = baseService.selectById(id);
        return entity != null ? ResultData.success(entity) : ResultData.fail("id为" + id + "的资源不存在");
    }

    /**
     * 删除 单资源带id
     *
     * @param id id
     * @return Result
     */
    @ApiOperation(value = "删除 单资源带id", notes = "返回删除之前的数据")
    @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Serializable id) {
        T selectEntity = baseService.selectById(id);
        if (selectEntity == null) {
            return ResultData.fail("id为" + id + "的资源不存在");
        }

        if (baseService.deleteById(id)) {
            return ResultData.success(selectEntity);
        }
        return ResultData.fail("删除失败");
    }

    /**
     * 更新 单资源带id
     *
     * @param id id
     * @return Result
     */
    @ApiOperation(value = "更新 单资源带id", notes = "返回更新之前的数据")
    @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "path")
    @PutMapping("/{id}")
    public Result update(@PathVariable("id") Serializable id, @RequestBody T entity) {
        T selectEntity = baseService.selectById(id);
        if (selectEntity == null) {
            return ResultData.fail("id为" + id + "的资源不存在");
        }

        if (baseService.update(id, selectEntity.getVersion(), entity)) {
            return ResultData.success(selectEntity);
        }
        return ResultData.fail("更新失败");
    }

    /**
     * 获取 多资源 分页
     *
     * @param currentPage 当前页
     * @param pageSize    页大小
     * @return Result
     */
    @ApiOperation(value = "获取 多资源 分页", notes = "当前页默认第1页，页大小默认10", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", required = false, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = false, paramType = "form", dataType = "int")
    })
    @GetMapping("/")
    public Result page(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<T> entityPage = baseService.selectPage(new Page<>(currentPage, pageSize),
                new EntityWrapper<T>().orderBy(BaseEntity.UPDATED_DT, false));
        return ResultData.page(entityPage);
    }

    /**
     * 获取 多资源 分页查询
     *
     * @param currentPage 当前页
     * @param pageSize    页大小
     * @param pageSearch  分页查询对象
     * @return Result
     */
    @ApiOperation(value = "获取 多资源 分页查询", notes = "当前页默认第1页，页大小默认10", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", required = false, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = false, paramType = "form", dataType = "int")
    })
    @PostMapping("/search")
    public Result pageSearch(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                             @RequestBody(required = false) PageSearch pageSearch) {
        Page<T> entityPage = baseService.pageSearch(currentPage, pageSize, pageSearch);
        return ResultData.page(entityPage);
    }

}
