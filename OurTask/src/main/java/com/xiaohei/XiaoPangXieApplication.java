package com.xiaohei;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(value = {"com.xiaohei.repository.mapper"})
@Slf4j
public class XiaoPangXieApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaoPangXieApplication.class, args);
        System.out.println("XiaoPangXieApplication 服务启动成功!");
        log.info("XiaoPangXieApplication 服务启动成功！");
    }
}
