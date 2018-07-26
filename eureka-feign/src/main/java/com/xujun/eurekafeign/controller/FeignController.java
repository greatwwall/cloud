package com.xujun.eurekafeign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xujun.eurekafeign.service.FeignService;

@RestController
public class FeignController {

	@Autowired
	private FeignService feignService;

	@GetMapping("/feign")
	public String feignInfo() {
		return feignService.feignConsumer();
	}
}
