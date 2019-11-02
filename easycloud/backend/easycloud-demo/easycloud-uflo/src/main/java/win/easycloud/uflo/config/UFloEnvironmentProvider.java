package win.easycloud.uflo.config;

import com.bstek.uflo.env.EnvironmentProvider;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author mortalliao
 */
@Component
public class UFloEnvironmentProvider implements EnvironmentProvider {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    /**
     * @return 返回流程引擎需要使用的Hibernate SessionFactory
     */
    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @return 返回与当前SessionFactory绑定的PlatformTransactionManager对象
     */
    @Override
    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }

    /**
     * 返回当前系统分类ID
     * getCategoryId方法返回null表示不对流程进行分类处理。
     * 只有该值为null 流程设计器里才也可以为空  该值主要用于saas多租户或者独立部署流程引擎时使用
     */
    @Override
    public String getCategoryId() {
        return null;
    }

    /**
     * getLoginUser方法用于返回当前登录用户的用户id 不是用户名!
     */
    @Override
    public String getLoginUser() {
        return "anonymous";
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setPlatformTransactionManager(
            PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }
}
