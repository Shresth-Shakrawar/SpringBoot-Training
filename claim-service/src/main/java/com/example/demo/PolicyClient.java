package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "policy-service")
public interface PolicyClient {
	@GetMapping("/api/policies/{policyId}/status")
	String getPolicyStatus(@PathVariable("policyId") String policyId);
	
}
