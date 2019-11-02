package com.gzedu.elcoud.feign.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.codingapi.tx.datasource.relational.LCNTransactionDataSource;
import com.codingapi.tx.springcloud.http.TransactionHttpRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

/**
 * @author mortal
 */
@Configuration
public class TxConfig {

    @Autowired
    private Environment env;

    @Bean
    @ConditionalOnClass(value = DruidDataSourceAutoConfigure.class)
    public LCNTransactionDataSource dataSource() {
//        DataSource dataSource = new DruidDataSourceBuilder().build(env, "spring.datasource.druid");
        DataSource dataSource = DruidDataSourceBuilder.create().build();
        LCNTransactionDataSource dataSourceProxy = new LCNTransactionDataSource();
        dataSourceProxy.setDataSource(dataSource);
        dataSourceProxy.setMaxCount(10);
        return dataSourceProxy;
    }

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate restTemplate() {
        return restTemplateBuilder.interceptors(new TransactionHttpRequestInterceptor()).build();
    }
}
