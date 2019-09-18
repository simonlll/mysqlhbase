package com.imooc.bigdata.hos.mybatis;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * Created by simon on 2019/8/20.
 */
public class HikariDataSourceFactory extends UnpooledDataSourceFactory {
    public HikariDataSourceFactory() {
        this.dataSource = new HikariDataSource();
    }
}
