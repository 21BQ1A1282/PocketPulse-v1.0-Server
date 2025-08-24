package com.msmk.PocketPulse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PocketPulseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocketPulseApplication.class, args);
	}

}
