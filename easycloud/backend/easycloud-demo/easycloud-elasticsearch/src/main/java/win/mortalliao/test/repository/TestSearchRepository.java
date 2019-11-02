package win.mortalliao.test.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import win.mortalliao.test.entity.Test;

/**
 * @author mortal
 */
public interface  TestSearchRepository extends ElasticsearchRepository<Test, Long> {
}
