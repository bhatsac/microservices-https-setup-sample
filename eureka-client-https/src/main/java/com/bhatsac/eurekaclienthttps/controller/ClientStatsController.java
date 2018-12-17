package com.bhatsac.eurekaclienthttps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientStatsController {

	@Autowired
	Environment env;
	
	@GetMapping("/isup")
	public String getServerStats(){
		return "Service is up and running on port="+env.getProperty("local.server.port");
	}
}
