package com.flyt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author wwang
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class flytApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(flytApplication.class, args);
        System.out.println("F.W.E 启动成功");
    }
}