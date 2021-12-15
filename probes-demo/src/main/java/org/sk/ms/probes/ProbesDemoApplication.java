package org.sk.ms.probes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.availability.ApplicationAvailabilityBean;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProbesDemoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ProbesDemoApplication.class, args);
	}

}
