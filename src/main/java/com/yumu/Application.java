package com.yumu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yumu.annotation.LocalConfigAnno;

import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.yumu.mapper")
@LocalConfigAnno
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
