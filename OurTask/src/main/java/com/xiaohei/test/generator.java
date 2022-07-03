package com.xiaohei.test;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * Created by cc on 2022/6/12
 */
public class generator {

    static final String URL = "jdbc:mysql://127.0.0.1/zane?useUnicode=true&characterEncoding=utf-8&useSSL=false";

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/OurTask/src/main/java/";
        String xmlPath = System.getProperty("user.dir") + "/OurTask/src/main/resources/mapper";

        FastAutoGenerator.create(URL, "root", "root")
                //全局配置
                .globalConfig(x -> x.author("xiao-pang").outputDir(path).disableOpenDir())
                //策略配置：哪些表
                .strategyConfig(x -> {
                    x.addInclude("basic,t_user,t_relation,t_integral,t_gift,t_task")
                            .addTablePrefix("t_")
                            .entityBuilder().idType(IdType.ASSIGN_UUID).versionColumnName("version").logicDeleteColumnName("is_deleted")
                            .enableColumnConstant().enableChainModel().enableTableFieldAnnotation()
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                    ;
                })

                //包配置
                .packageConfig(x -> x.parent("com.xiaohei").entity("po").controller("controller").service("service")
                        .serviceImpl("service.impl").mapper("mapper").xml("mapper.xml")
                        .pathInfo(new HashMap<OutputFile, String>() {{
                            put(OutputFile.xml, xmlPath);
                        }}))

                //模板引擎
                .templateEngine(new VelocityTemplateEngine())
                .execute();
    }

}
