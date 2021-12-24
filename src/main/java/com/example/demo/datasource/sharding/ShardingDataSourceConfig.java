package com.example.demo.datasource.sharding;

import java.util.Properties;

public interface ShardingDataSourceConfig {

    default Properties defaultPropsConfig(){
        Properties shardingProperties = new Properties();
        shardingProperties.setProperty("sql.show", "false");

        return shardingProperties;
    }

}
