package com.example.energymanagement.service;

import com.example.energymanagement.model.domain.Device;
import com.example.energymanagement.model.param.DeviceBaseParam;
import com.example.energymanagement.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Device getDeviceById(Integer did) {
        return deviceRepository.getDeviceById(did);
    }

    public List<Device> listDeviceBySid(Integer sid) {
        return deviceRepository.listDeviceBySid(sid);
    }

    public List<Device> listDeviceByTid(Integer tid) {
        return deviceRepository.listDeviceByTid(tid);
    }

    public int updateDevice(DeviceBaseParam param) {
        Device device = new Device();
        copyProperties(param, device);
        return deviceRepository.updateDevice(device);
    }

    public int deleteDeviceById(Integer did) {
        return deviceRepository.deleteDeviceById(did);
    }

    public int insertDevice(DeviceBaseParam param) {
        Device device = new Device();
        copyProperties(param, device);
        return deviceRepository.insertDevice(device);
    }

    public int deleteDeviceBySid(Integer sid) {
        return deviceRepository.deleteDeviceBySid(sid);
    }
}
