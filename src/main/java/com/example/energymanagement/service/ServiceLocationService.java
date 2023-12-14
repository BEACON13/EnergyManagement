package com.example.energymanagement.service;

import com.example.energymanagement.repository.ServiceLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLocationService {

    @Autowired
    private ServiceLocationRepository serviceLocationRepository;


}
