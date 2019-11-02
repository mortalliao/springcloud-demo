package win.mortalliao.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.marker.ObjectFieldsAppendingMarker;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.mortalliao.starter.common.controller.BaseController;
import win.mortalliao.test.entity.Test;
import win.mortalliao.test.repository.TestSearchRepository;
import win.mortalliao.test.service.TestService;

/**
 * 测试表 前端控制器
 *
 * @author liaoyuajin
 * @since 2017-11-16
 */
@RestController
@RequestMapping("/test/")
@Api(description = "测试表", tags = "测试表")
@Slf4j
public class TestController extends BaseController<Test> {

    @Autowired
    TestService testService;

    @Autowired
    private TestSearchRepository testSearchRepository;

    @ApiOperation("add")
    @PutMapping("/add")
    public void testSaveTestIndex() {
        Test test = testService.selectById(69);
        testSearchRepository.save(test);
    }

    @ApiOperation("query")
    @GetMapping("/query")
    public void testSearch() {
        //搜索关键字
        String queryString = "刘";
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
        Iterable<Test> searchResult = testSearchRepository.search(builder);
        for (Test aSearchResult : searchResult) {
            log.info("query object is {} ！", aSearchResult);
            log.info(MarkerFactory.getMarker(ObjectFieldsAppendingMarker.MARKER_NAME), "query object is {} ！", aSearchResult);
        }
    }

}
