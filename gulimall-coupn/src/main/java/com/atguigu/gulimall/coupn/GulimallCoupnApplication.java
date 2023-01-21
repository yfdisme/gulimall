package com.atguigu.gulimall.coupn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GulimallCoupnApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallCoupnApplication.class, args);
	}

}
