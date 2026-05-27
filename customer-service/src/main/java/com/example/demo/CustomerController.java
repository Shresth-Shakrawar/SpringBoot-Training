package com.example.demo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @GetMapping("/{customerId}/verify")
    public boolean verifyCustomerInfo(@PathVariable String customerId) {
        // Mock verification: Any customer ID not starting with "fail" is valid
        return !customerId.toLowerCase().startsWith("fail");
    }
}