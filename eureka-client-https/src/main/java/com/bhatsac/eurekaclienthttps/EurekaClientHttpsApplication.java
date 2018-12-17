package com.bhatsac.eurekaclienthttps;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl.EurekaJerseyClientBuilder;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientHttpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientHttpsApplication.class, args);
	}
	@Bean
	public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() throws NoSuchAlgorithmException {
		DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
		System.out.println("*******************************************************");
		System.out.println("*******************************************************");
		System.out.println();
		System.out.println("*******************************************************");
		System.out.println("*******************************************************");
		File keyStore =null;
		File trustStore =null;
		try {
			 keyStore = ResourceUtils.getFile("classpath:certs/client.jks");
			 trustStore = ResourceUtils.getFile("classpath:certs/clientTrustStore.jks");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.setProperty("javax.net.ssl.keyStore", keyStore.toString());
		System.setProperty("javax.net.ssl.keyStorePassword", "client");
		System.setProperty("javax.net.ssl.trustStore", trustStore.toString());
		System.setProperty("javax.net.ssl.trustStorePassword", "client");
		EurekaJerseyClientBuilder builder = new EurekaJerseyClientBuilder();
		builder.withClientName("client");
		builder.withSystemSSLConfiguration();
		builder.withMaxTotalConnections(10);
		builder.withMaxConnectionsPerHost(10);
		args.setEurekaJerseyClient(builder.build());
		return args;
	}
}

