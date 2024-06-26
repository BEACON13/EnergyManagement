package com.example.energymanagement.controller;

import com.example.energymanagement.model.domain.Customer;
import com.example.energymanagement.model.param.CustomerBaseParam;
import com.example.energymanagement.service.CustomerService;
import com.example.energymanagement.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * login
     *
     * @param param the login info
     * @return the token
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CustomerBaseParam param) {
        Customer customer = customerService.login(param.getEmail(), param.getPassword());
        if (customer != null) {
            String token = TokenUtil.generateToken(customer.getcId());
            Map<String, String> map = Map.of("token", token);
            return ResponseEntity.ok().body(map);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    /**
     * register
     * @param param the register info
     * @return the token
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CustomerBaseParam param) {
        Customer customer = customerService.findByEmail(param.getEmail());
        if (customer != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }
        customer = customerService.register(param.getName(), param.getPassword(), param.getEmail(), param.getBillingAddress(), param.getPhone());
        String token = TokenUtil.generateToken(customer.getcId());
        Map<String, String> map = Map.of("token", token);
        return ResponseEntity.ok().body(map);
    }
}
