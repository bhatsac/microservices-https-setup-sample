package com.bhatsac.eurekadiscoveryhttps;

import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl.EurekaJerseyClientBuilder;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoveryHttpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscoveryHttpsApplication.class, args);
	}
	
}

