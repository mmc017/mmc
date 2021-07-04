package com.example.bootstudy;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BootstudyApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(BootstudyApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run();
//		SpringApplication.run(BootstudyApplication.class, args);
	}

}
