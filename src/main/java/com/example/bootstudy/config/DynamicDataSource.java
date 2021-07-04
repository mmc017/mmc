package com.example.bootstudy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
 
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
 
    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }
 
    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }
 
    public static void setDataSource(String dataSource){
        log.info("切换到数据源-->"+dataSource);
        contextHolder.set(dataSource);
    }
 
    public static String getDataSource(){
        return  contextHolder.get();
    }
 
    public static void clearDataSource(){
        contextHolder.remove();
    }
}
