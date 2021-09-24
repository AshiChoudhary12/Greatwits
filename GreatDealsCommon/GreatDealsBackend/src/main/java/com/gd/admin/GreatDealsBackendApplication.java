package com.gd.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.gd.common.entity", "com.gd.admin.user"})
public class GreatDealsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatDealsBackendApplication.class, args);
	}

}
	