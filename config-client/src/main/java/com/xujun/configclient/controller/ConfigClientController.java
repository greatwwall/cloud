package com.xujun.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

	@Value("${test}")
	private String test;

	@GetMapping("/info")
	public String info() {
		return test;
	}
}
