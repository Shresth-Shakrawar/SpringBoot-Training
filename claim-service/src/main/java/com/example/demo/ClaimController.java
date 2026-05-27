package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
	@Autowired
	private PolicyClient policyClient;
	
	@PostMapping("/verify")
	public String verifyClaim(@RequestParam String claimId,@RequestParam String policyId) {
		String policyStatus = policyClient.getPolicyStatus(policyId);
		if (!"ACTIVE".equalsIgnoreCase(policyStatus)) {
            return "Claim " + claimId + " Rejected: Policy " + policyId + " is not active.";
        }
        return "Claim " + claimId + " verified and queued for processing.";
	}
	

}
