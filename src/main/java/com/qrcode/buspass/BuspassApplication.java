package com.qrcode.buspass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.qrcode.buspass")
@EnableAutoConfiguration
public class BuspassApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuspassApplication.class, args);
	}

}
