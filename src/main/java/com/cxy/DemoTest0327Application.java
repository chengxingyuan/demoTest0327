package com.cxy;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.cxy.mapper")
@SpringBootApplication
@EnableScheduling
public class DemoTest0327Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoTest0327Application.class, args);
	}


}
