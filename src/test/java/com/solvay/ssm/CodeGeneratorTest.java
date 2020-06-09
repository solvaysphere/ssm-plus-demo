package com.solvay.ssm;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class CodeGeneratorTest {

    /**
     * 代码生成 示例代码
     */
    @Test
    public void testGenerator() {

        // 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)
                .setIdType(IdType.AUTO)
                .setAuthor("Solvay")
                .setOutputDir("/Users/lanternfish/WorkSpace/SpringCode/github/ssm-plus-demo/src/main/java")
                .setFileOverride(true)
                .setSwagger2(true)
                .setEnableCache(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setServiceName("%sService");

        // 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://134.134.2.70:33061/mp")
                .setUsername("root")
                .setPassword("123456");

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true)
                .setChainModel(true)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix("tb_")
                .setInclude("tb_employee");

        // 包配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.solvay.ssm")
                .setEntity("entity")
                .setController("controller")
                .setMapper("dao")
                .setService("service")
                .setXml("mappers");

        //整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(strategy)
                .setPackageInfo(pkConfig);

        //执行
        ag.execute();
    }
}
