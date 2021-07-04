//package com.example.bootstudy.config;
//
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import com.example.bootstudy.aop.datasource.DataSourceConstants;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class DynamicDataSourceConfig {
//
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.testone")
//    public DataSource testOneDataSource() {
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.testtwo")
//    public DataSource testTwoDataSource() {
//        return DruidDataSourceBuilder.create().build();
//    }
//
//
//    @Bean
//    @Primary
//    public DynamicDataSource dataSource() {
//        Map<Object, Object> targetDataSource = new HashMap<>();
//        targetDataSource.put(DataSourceConstants.testOne, testOneDataSource());
//        targetDataSource.put(DataSourceConstants.testTwo, testTwoDataSource());
//        return new DynamicDataSource(testOneDataSource(), targetDataSource);
//    }
//}
