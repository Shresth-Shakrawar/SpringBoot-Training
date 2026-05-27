package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private CustomerClient customerClient;

    @PostMapping("/{policyId}/approve")
    public String approvePolicy(@PathVariable String policyId, @RequestParam String customerId) {
        // Inter-service call to Customer Service
        boolean isCustomerValid = customerClient.verifyCustomerInfo(customerId);
        
        if (!isCustomerValid) {
            return "Policy Approval Failed: Customer verification failed.";
        }
        return "Policy " + policyId + " successfully approved for customer " + customerId;
    }

    @GetMapping("/{policyId}/status")
    public String getPolicyStatus(@PathVariable String policyId) {
        // Mock status
        return "ACTIVE";
    }
}