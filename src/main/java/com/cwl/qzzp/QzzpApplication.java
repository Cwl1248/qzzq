package com.cwl.qzzp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.cwl.qzzp.dao"})
public class QzzpApplication {

    public static void main(String[] args) {
        SpringApplication.run(QzzpApplication.class, args);
    }

}
