package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	@PostMapping("/premium")
	public String processPayments(@RequestParam String policyId,@RequestParam double amount) {
		if(amount>0) {
			return "Premium payment of "+amount +"R for policy " + policyId + " processed successfully.";
		}
		return "Payment Failed For policy " + policyId;
	}
}
