package zy.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import zy.util.param.GeneratorParam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    public static void main(String[] args) {
        GeneratorParam generatorParam = new GeneratorParam();
        generatorParam.setAuthor("zy");
        generatorParam.setDataSourceUrl("jdbc:mysql://localhost:3306/vue_shop?useSSL=false&serverTimezone=UTC");
        generatorParam.setDataSourcePassword("123456");
        generatorParam.setDataSourceUserName("root");
        generatorParam.setModularName("decotation");
        generatorParam.setModularPath("zy");
        generatorParam.setProjectPath("D:\\code\\auto-offer");
        generatorParam.setOutPutPath(generatorParam.getProjectPath()+"\\src\\main\\java");
//        generatorParam.setTemplatePath();
        generator(generatorParam);
    }

    public static void generator(GeneratorParam generatorParam) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(generatorParam.getOutPutPath());
        gc.setAuthor(generatorParam.getAuthor());
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(generatorParam.getDataSourceUrl());
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(generatorParam.getDataSourceUserName());
        dsc.setPassword(generatorParam.getDataSourcePassword());
        dsc.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                if(fieldType.toUpperCase().contains("DATE")){
                    return DbColumnType.DATE;
                }
                return (DbColumnType)
                        super.processTypeConvert(globalConfig,fieldType);
            }
        });
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(generatorParam.getModularName());
        pc.setParent(generatorParam.getModularPath());
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return generatorParam.getProjectPath() + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir(filePath);
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
         templateConfig.setEntity("/templates/entity.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        //逻辑删除字段名称
        strategy.setLogicDeleteFieldName("DEL_FLAG");
        //填充字段
        List<TableFill> list = new ArrayList<>();
        TableFill createTime = new TableFill("CREATE_TIME", FieldFill.INSERT);
        TableFill createUser = new TableFill("CREATE_USER", FieldFill.INSERT);
        TableFill updateTime = new TableFill("UPDATE_TIME", FieldFill.UPDATE);
        TableFill updateUser = new TableFill("UPDATE_USER", FieldFill.UPDATE);
        TableFill delFlag = new TableFill("DEL_FLAG", FieldFill.INSERT);
        list.add(createTime);
        list.add(createUser);
        list.add(updateTime);
        list.add(updateUser);
        list.add(delFlag);
        strategy.setTableFillList(list);
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
        strategy.setInclude("decotaion");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}