package com.example.energymanagement.service;

import com.example.energymanagement.model.domain.ServiceLocation;
import com.example.energymanagement.model.param.ServiceLocationBaseParam;
import com.example.energymanagement.repository.DeviceRepository;
import com.example.energymanagement.repository.ServiceLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class ServiceLocationService {

    @Autowired
    private ServiceLocationRepository serviceLocationRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    public List<ServiceLocation> listServiceLocationByCustomerId(Integer customerId) {
        return serviceLocationRepository.listByCustomerId(customerId);
    }

    public boolean insertServiceLocation(ServiceLocationBaseParam param) {
        ServiceLocation serviceLocation = new ServiceLocation();
        copyProperties(param, serviceLocation);
        return serviceLocationRepository.insertServiceLocation(serviceLocation);
    }

    public int updateServiceLocation(ServiceLocationBaseParam param) {
        ServiceLocation serviceLocation = new ServiceLocation();
        copyProperties(param, serviceLocation);
        return serviceLocationRepository.updateServiceLocation(serviceLocation);
    }

    public boolean deleteServiceLocation(Integer sId) {
        deviceRepository.deleteDeviceBySid(sId);
        return serviceLocationRepository.deleteServiceLocation(sId);
    }

}
