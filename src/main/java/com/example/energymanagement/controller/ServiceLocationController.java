package com.example.energymanagement.controller;

import com.example.energymanagement.model.domain.ServiceLocation;
import com.example.energymanagement.model.param.ServiceLocationBaseParam;
import com.example.energymanagement.service.ServiceLocationService;
import com.example.energymanagement.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/service-location")
public class ServiceLocationController {

    @Autowired
    private ServiceLocationService serviceLocationService;

    /**
     * list all the service location of the current customer
     *
     * @param token the token of the current customer
     * @return the list of service location
     */
    @PostMapping("/list")
    public ResponseEntity<?> listServiceLocation(@RequestHeader("Authorization") String token) {
        Integer id = TokenUtil.getUserInfoFromToken(token);
        List<ServiceLocation> serviceLocations = serviceLocationService.listServiceLocationByCustomerId(id);
        return ResponseEntity.ok().body(serviceLocations);
    }

    /**
     * insert a new service location
     *
     * @param token the token of the current customer
     * @param param the param of the new service location
     * @return the result of the insert
     */
    @PostMapping("/insert")
    public ResponseEntity<?> insertServiceLocation(@RequestHeader("Authorization") String token, @RequestBody ServiceLocationBaseParam param) {
        Integer id = TokenUtil.getUserInfoFromToken(token);
        param.setCId(id);
        if (serviceLocationService.insertServiceLocation(param)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insert failed");
    }


    /**
     * update a service location
     *
     * @param param the param of the service location
     * @return the result of the update
     */
    @PostMapping("/update")
    public ResponseEntity<?> updateServiceLocation(@RequestBody ServiceLocationBaseParam param) {
        if (param.getSId() == null) {
            return ResponseEntity.badRequest().body("Service location ID is required");
        }
        if (serviceLocationService.updateServiceLocation(param) == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Update failed");
        }
        return ResponseEntity.ok().build();
    }
}
