package com.cnct.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Profile:spring提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *
 */

@Configuration
public class MainConfigOfProfile {

    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        //dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/");
        return  dataSource;
    }

}

