package com.gzedu.ecloud.generator;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * CodeGenerator 代码生成
 */
public class CodeGenerator {

    // 作者
    private static String author = "liaoyujian";

    // 输出目录
    private static String outputDir = "D:\\Work\\log";

    // 数据库类型
    private static DbType dbType = DbType.MYSQL;

    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "123456";
    //private static String url = "jdbc:mysql://172.16.146.83:3306/DC_OPEN_TEACHER_SQ";
    private static String url = "jdbc:mysql://localhost:3306/node";

    // 表前缀
    public static String[] tablePrefix = new String[]{"pri_", "jf_"};

    // 需要生成的表
    public static String[] include = new String[]{"demo_copy"};
    // 排除生成的表
    public static String[] exclude = new String[]{};
    // 自定义实体，公共字段
    public static String[] superEntityColumns = new String[]{"id", "version", "is_deleted", "created_by", "created_dt", "updated_by", "updated_dt"};
//    public static String[] superEntityColumns = new String[]{"version", "is_deleted", "created_by", "created_dt", "updated_by", "updated_dt"};

    // 自定义包路径
    public static String moduleName = "democopy";

    // mapper的XML文件
    public static String outputMapper = "D:\\Work\\log\\mapper\\";

    //---------------------------------------以下可以不用配置------------------------------------------------------

    //是否覆盖文件
    private static boolean fileOverride = true;

    // 开启 activeRecord 模式
    private static boolean activeRecord = true;

    // XML 二级缓存
    private static boolean enableCache = false;

    // XML ResultMap
    private static boolean baseResultMap = true;

    // XML columList
    private static boolean baseColumnList = true;

    // 自定义文件命名，注意 %s 会自动填充表实体属性
    private static String mapperName = "%sMapper";
    private static String xmlName = "%sMapper";
    private static String serviceName = "%sService";
    private static String serviceImplName = "%sServiceImpl";
    private static String controllerName = "%sController";

    // 全局大写命名
    public static boolean capitalMode = false;
    // 全局下划线命名
    public static boolean dbColumnUnderline = false;

    // 包路径
    public static String parent = "com.gzedu.ecloud";

    // 表名生成策略
    public static NamingStrategy namingStrategy = NamingStrategy.underline_to_camel;

    // 自定义实体父类
    public static String superEntityClass = "AutoIdEntity"; // 主键自增实体类
//    public static String superEntityClass = "BaseEntity"; // 包含基本6个字段实体类
    // 自定义 mapper 父类
    public static String superMapperClass = "SuperMapper";
    // 自定义 service 父类
    public static String superServiceClass = "BaseService";
    // 自定义 service 实现类父类
    public static String superServiceImplClass = "BaseServiceImpl";
    // 自定义 controller 父类
    public static String superControllerClass = "BaseController";
    // 是否为RestController
    public static boolean restControllerStyle = true;
    //【实体】是否生成字段常量  如：public static final String ID = "test_id";
    public static boolean entityColumnConstant = true;
    // 乐观锁属性名称
    public static String versionFieldName = "version";
    // 逻辑删除属性名称
    public static String logicDeleteFieldName = "is_deleted";
    //【实体】是否为构建者模型（默认 false）如：public User setName(String name) {this.name = name; return this;}
    public static boolean entityBuilderModel = true;
    //【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
    public static boolean entityLombokModel = true;
    // Boolean类型字段是否移除is前缀处理 比如 : 数据库字段名称 : 'is_xxx',类型为 : tinyint. 在映射实体的时候则会去掉is,在实体类中映射最终结果为 xxx
    public static boolean entityBooleanColumnRemoveIsPrefix = true;
    // 驼峰转连字符
    public static boolean controllerMappingHyphenStyle = true;

    // 这里是控制器包名，默认 web
    public static String controller = "controller";
    public static String entity = "entity";
    public static String mapper = "mapper";
    public static String service = "service";
    public static String serviceImpl = "service.impl";
    public static String xml = "mapper.xml";

    /**
     * 全局配置
     *
     * @return GlobalConfig
     */
    public static GlobalConfig globalConfig() {
        return new GlobalConfig()
                .setOutputDir(outputDir)
                .setFileOverride(fileOverride)
                .setActiveRecord(activeRecord)
                .setEnableCache(enableCache)
                .setBaseResultMap(baseResultMap)
                .setBaseColumnList(baseColumnList)
                .setAuthor(author)
                .setMapperName(mapperName)
                .setXmlName(xmlName)
                .setServiceName(serviceName)
                .setServiceImplName(serviceImplName)
                .setControllerName(controllerName);
    }

    /**
     * 数据源配置
     *
     * @return DataSourceConfig
     */
    public static DataSourceConfig dataSourceConfig() {
        return new DataSourceConfig()
                .setDbType(dbType)// 数据库类型
                .setTypeConvert(iTypeConvert())
                .setDriverName(driverName)
                .setUsername(username)
                .setPassword(password)
                .setUrl(url);
    }

    // 自定义数据库表字段类型转换【可选】
    public static ITypeConvert iTypeConvert() {
        return new MySqlTypeConvert() {
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                //System.out.println("转换类型：" + fieldType);
                // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                //    return DbColumnType.BOOLEAN;
                // }
                return super.processTypeConvert(fieldType);
            }
        };
    }

    /**
     * 策略配置
     *
     * @return StrategyConfig
     */
    public static StrategyConfig strategyConfig() {
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));
        return new StrategyConfig()
                .setTableFillList(tableFillList)
                .setCapitalMode(capitalMode)
                .setDbColumnUnderline(dbColumnUnderline)
                .setTablePrefix(tablePrefix)
                .setNaming(namingStrategy)
                .setInclude(include)
                //.setExclude(exclude)
                .setSuperEntityColumns(superEntityColumns)
                .setSuperEntityClass(superEntityClass)
                .setSuperMapperClass(superMapperClass)
                .setSuperServiceClass(superServiceClass)
                .setSuperServiceImplClass(superServiceImplClass)
                .setSuperControllerClass(superControllerClass)
                .setRestControllerStyle(restControllerStyle)
                .setEntityColumnConstant(entityColumnConstant)
                .setVersionFieldName(versionFieldName)
                .setLogicDeleteFieldName(logicDeleteFieldName)
                .setEntityBuilderModel(entityBuilderModel)
                .setEntityLombokModel(entityLombokModel)
                .setEntityBooleanColumnRemoveIsPrefix(entityBooleanColumnRemoveIsPrefix)
                .setControllerMappingHyphenStyle(controllerMappingHyphenStyle);
    }

    /**
     * 包配置
     *
     * @return PackageConfig
     */
    public static PackageConfig packageConfig() {
        return new PackageConfig()
                .setModuleName(moduleName)
                .setParent(parent)
                .setController(controller)
                .setEntity(entity)
                .setMapper(mapper)
                .setService(service)
                .setServiceImpl(serviceImpl)
                .setXml(xml);
    }

    /**
     * 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
     *
     * @return InjectionConfig
     */
    public static InjectionConfig injectionConfig() {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = Collections.emptyMap();
                //map.put("abc", this.getConfig().getGlobalConfig().getAuthor());
                this.setMap(map);
            }
        }.setFileOutConfigList(fileOutConfigList());
    }

    // 自定义输出文件目录
    public static List<FileOutConfig> fileOutConfigList() {
        return Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return outputMapper + tableInfo.getEntityName() + ".xml";
            }
        });
    }

    public static TemplateConfig templateConfig() {
        // 关闭默认 xml 生成，调整生成 至 根目录
        return new TemplateConfig().setXml(null);
    }

    /**
     * 代码生成
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(globalConfig())
                .setDataSource(dataSourceConfig())
                .setStrategy(strategyConfig())
                .setPackageInfo(packageConfig())
                .setCfg(injectionConfig())
                .setTemplate(templateConfig());

        // 执行生成
        mpg.execute();
    }

}
