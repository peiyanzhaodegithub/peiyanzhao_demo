package com.example.demo.datasource.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author lidong9144@163.com 2018/8/31
 */
public class DBTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    private int dbNumPower;
    private int tableNum;

    private DBTableShardingAlgorithm() {}

    public DBTableShardingAlgorithm(int dbNumPower, int tableNum) {
        this.dbNumPower = dbNumPower;
        this.tableNum = tableNum;
    }

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
//        long tableNum = Long.valueOf(shardingValue.getValue()) / MyConstant.SHARDING_DB_NUM % MyConstant.SHARDING_TABLE_NUM;
        long tableEnd = (shardingValue.getValue() >> dbNumPower) & (tableNum - 1);

        for (String availableTargetName : availableTargetNames) {
            if (availableTargetName.endsWith(tableEnd + "")) {
                return availableTargetName;
            }
        }

        throw new UnsupportedOperationException("can not find sharding table by id: " + shardingValue + ", tableNum: " + tableNum);
    }

}
