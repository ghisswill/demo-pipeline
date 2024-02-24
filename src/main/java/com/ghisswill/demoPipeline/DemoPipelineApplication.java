package com.ghisswill.demoPipeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DemoPipelineApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoPipelineApplication.class, args);
	}

}
