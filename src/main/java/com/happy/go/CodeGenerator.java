//package com.hayouka.Chitanda;
package com.happy.go;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {
    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator generator = new AutoGenerator();
// 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir")+"src/main/java/com/happy/go");
        globalConfig.setAuthor("fandz");
        globalConfig.setFileOverride(false);

        generator.setGlobalConfig(globalConfig);
// 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mybatis?serverTimezone=GMT&characterEncoding=utf8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        generator.setDataSource(dataSourceConfig);
        // 包配置
        PackageConfig packageConfig = new PackageConfig();
//        packageConfig.setParent(null);
        packageConfig.setParent("com.happy.go");
        packageConfig.setMapper("mapper");
        generator.setPackageInfo(packageConfig);


        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setInclude("user_s","user");//表名,可一个可多个
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        generator.setStrategy(strategyConfig);
        generator.execute();

    }
}
