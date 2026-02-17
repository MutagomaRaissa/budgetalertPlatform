package com.budgetalert.projectservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.budgetalert.projectservice.client")
@SpringBootApplication
public class ProjectserviceApplication {

	public static void main(String[] args) {

        SpringApplication.run(ProjectserviceApplication.class, args);
	}


}
