package com.ly.id;

import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;

/***
 * 自定义主键生成策略
 */
public class MyId implements ShardingKeyGenerator{


    @Override
    public Comparable<?> generateKey() {
        return new SnowflakeShardingKeyGenerator().generateKey();
    }

    @Override
    public String getType() {
        return "custom";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
