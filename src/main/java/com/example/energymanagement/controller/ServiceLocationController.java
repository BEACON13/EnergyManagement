package com.example.energymanagement.controller;

import com.example.energymanagement.model.domain.ServiceLocation;
import com.example.energymanagement.service.ServiceLocationService;
import com.example.energymanagement.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service-location")
public class ServiceLocationController {

    @Autowired
    private ServiceLocationService serviceLocationService;

    @PostMapping("/list")
    public ResponseEntity<?> listServiceLocation(@RequestHeader("Authorization") String token) {
        Integer id = TokenUtil.getUserInfoFromToken(token);
        List<ServiceLocation> serviceLocations = serviceLocationService.listServiceLocationByCustomerId(id);
        return ResponseEntity.ok().body(serviceLocations);
    }


}
