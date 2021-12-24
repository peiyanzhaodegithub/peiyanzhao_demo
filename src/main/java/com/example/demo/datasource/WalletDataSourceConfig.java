package com.example.demo.datasource;
import com.example.demo.datasource.sharding.DBShardingAlgorithm;
import com.example.demo.datasource.sharding.DBTableShardingAlgorithm;
import com.example.demo.datasource.sharding.ShardingDataSourceConfig;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lidong9144@163.com 2018/10/11
 */
@Configuration
@MapperScan(basePackages = "com.example.demo.test.mapper",
        annotationClass = Repository.class,
        sqlSessionFactoryRef = WalletDataSourceConfig.SQL_SESSION_FACTORY_NAME)
public class WalletDataSourceConfig implements ShardingDataSourceConfig {
    static final String SQL_SESSION_FACTORY_NAME = "sessionFactoryWallet";
    private static final String TX_MANAGER = "txManagerWallet";

    @Value("${sharding.db.num.power}")
    private int dbNumPower;
    @Value("${sharding.table.num.power}")
    private int tableNumPower;


    @Bean(name = "dataSource0")
    @ConfigurationProperties(prefix = "spring.datasource0")
    @Primary
    public DataSource dataSource0() throws SQLException {
        DataSource dataSource = DataSourceBuilder.create().build();

        return dataSource;
    }

    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource1")
    @Primary
    public DataSource dataSource1() {
        DataSource dataSource = DataSourceBuilder.create().build();

        return dataSource;
    }

    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource2")
    @Primary
    public DataSource dataSource2() {
        DataSource dataSource = DataSourceBuilder.create().build();

        return dataSource;
    }

    @Bean(name = "dataSource3")
    @ConfigurationProperties(prefix = "spring.datasource3")
    @Primary
    public DataSource dataSource3() {
        DataSource dataSource = DataSourceBuilder.create().build();

        return dataSource;
    }

    @Bean(name = "dataSource4")
    @ConfigurationProperties(prefix = "spring.datasource4")
    @Primary
    public DataSource dataSource4() {
        DataSource dataSource = DataSourceBuilder.create().build();

        return dataSource;
    }

    @Bean(name = "dataSource5")
    @ConfigurationProperties(prefix = "spring.datasource5")
    @Primary
    public DataSource dataSource5() {
        DataSource dataSource = DataSourceBuilder.create().build();

        return dataSource;
    }

    @Bean(name = "dataSource6")
    @ConfigurationProperties(prefix = "spring.datasource6")
    @Primary
    public DataSource dataSource6() {
        DataSource dataSource = DataSourceBuilder.create().build();

        return dataSource;
    }

    @Bean(name = "dataSource7")
    @ConfigurationProperties(prefix = "spring.datasource7")
    @Primary
    public DataSource dataSource7() {
        DataSource dataSource = DataSourceBuilder.create().build();

        return dataSource;
    }

    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("wallet_0", dataSource0());
        dataSourceMap.put("wallet_1", dataSource1());
        dataSourceMap.put("wallet_2", dataSource2());
        dataSourceMap.put("wallet_3", dataSource3());
        dataSourceMap.put("wallet_4", dataSource4());
        dataSourceMap.put("wallet_5", dataSource5());
        dataSourceMap.put("wallet_6", dataSource6());
        dataSourceMap.put("wallet_7", dataSource7());

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        genConfig("user_wallet", shardingRuleConfig);
        genConfig("wallet_log", shardingRuleConfig);
        genConfig("wallet_order", shardingRuleConfig);
        genConfig("wallet_order_detail", shardingRuleConfig);
        genConfig("wallet_order_pay", shardingRuleConfig);
        genConfig("wallet_order_refund", shardingRuleConfig);
        genConfig("wallet_log_split", shardingRuleConfig);
        genSingleTableConfig("notify_log", shardingRuleConfig);
        genSingleTableConfig("wallet_type", shardingRuleConfig, 1);

        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, defaultPropsConfig());
    }

    @Bean(name = TX_MANAGER)
    @Primary
    public PlatformTransactionManager txManagerMdPayRecord() throws SQLException {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = SQL_SESSION_FACTORY_NAME)
    @Primary
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper-walletdb/*.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource());

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLocalCacheScope(LocalCacheScope.STATEMENT);
        sqlSessionFactoryBean.setConfiguration(configuration);

        return sqlSessionFactoryBean.getObject();
    }

    private void genSingleTableConfig(String table, ShardingRuleConfiguration shardingRuleConfig) {
        int dbNum = (int) Math.pow(2, dbNumPower);
        int tableNum = 1;

        TableRuleConfiguration config = new TableRuleConfiguration(table, genDataNodes("wallet", dbNum, table, tableNum));
        config.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", new DBShardingAlgorithm(dbNum)));

        shardingRuleConfig.getTableRuleConfigs().add(config);
    }

    private void genSingleTableConfig(String table, ShardingRuleConfiguration shardingRuleConfig, int dbNum) {
        int tableNum = 1;

        TableRuleConfiguration config = new TableRuleConfiguration(table, genDataNodes("wallet", dbNum, table, tableNum));
        config.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", new DBShardingAlgorithm(dbNum)));
        config.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration(
                "user_id", new DBTableShardingAlgorithm(dbNumPower, 1)));

        shardingRuleConfig.getTableRuleConfigs().add(config);
    }

    private void genConfig(String table, ShardingRuleConfiguration shardingRuleConfig) {
        int dbNum = (int) Math.pow(2, dbNumPower);
        int tableNum = (int) Math.pow(2, tableNumPower);

        TableRuleConfiguration config = new TableRuleConfiguration(table, genDataNodes("wallet", dbNum, table, tableNum));
        config.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", new DBShardingAlgorithm(dbNum)));
        config.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration(
                "user_id", new DBTableShardingAlgorithm(dbNumPower, tableNum)));

        shardingRuleConfig.getTableRuleConfigs().add(config);
    }

    private String genDataNodes(String db, int dbNum, String table, int tableNum) {
        return String.format("%s_${0..%d}.%s_${0..%d}", db, dbNum - 1, table, tableNum - 1);
    }

}
