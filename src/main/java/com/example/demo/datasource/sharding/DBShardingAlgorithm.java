package com.example.demo.datasource.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author lidong9144@163.com 2018/8/30
 */
public class DBShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    private int dbNum;

    private DBShardingAlgorithm() {}

    public DBShardingAlgorithm(int dbNum) {
        this.dbNum = dbNum;
    }

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
//        long dbNum = Long.valueOf(shardingValue.getValue()) % (MyConstant.SHARDING_DB_NUM);
        long dbEnd = shardingValue.getValue() & (dbNum - 1);

        for (String availableTargetName : availableTargetNames) {
            if (availableTargetName.endsWith(dbEnd + "")) {
                return availableTargetName;
            }
        }

        throw new UnsupportedOperationException("can not find sharding database by id: " + shardingValue);
    }

}
