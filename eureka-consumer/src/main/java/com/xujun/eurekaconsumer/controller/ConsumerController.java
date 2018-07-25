package com.xujun.eurekaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/info")
	public String info() {
		return "Service eureka-consumer";
	}

	@GetMapping("/consumer")
	public String consumer() {
		ServiceInstance instance = loadBalancerClient.choose("eureka-client");
		String url = "http://" + instance.getHost() + ":" + instance.getPort()
				+ "/info";
		System.out.println("url: " + url);
		return restTemplate.getForObject(url, String.class);
	}

}
