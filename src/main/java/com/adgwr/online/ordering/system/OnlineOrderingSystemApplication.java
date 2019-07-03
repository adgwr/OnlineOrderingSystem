package com.adgwr.online.ordering.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan(basePackages = "com.adgwr.online.ordering.system.mapper")
public class OnlineOrderingSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineOrderingSystemApplication.class,args);
    }
}
