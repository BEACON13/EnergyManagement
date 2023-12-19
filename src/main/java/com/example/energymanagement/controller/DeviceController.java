package com.example.energymanagement.controller;

import com.example.energymanagement.model.domain.Device;
import com.example.energymanagement.model.param.DeviceBaseParam;
import com.example.energymanagement.service.DeviceService;
import com.example.energymanagement.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/list")
    public ResponseEntity<?> listDevice(@RequestHeader("Authorization") String token) {
        Integer id = TokenUtil.getUserInfoFromToken(token);
        List<Device> devices = deviceService.listDeviceBySid(id);
        return ResponseEntity.ok().body(devices);
    }

    @PostMapping("/listByTid")
    public ResponseEntity<?> listDeviceByTid(@RequestBody DeviceBaseParam param) {
        List<Device> devices = deviceService.listDeviceByTid(param.getTid());
        return ResponseEntity.ok().body(devices);
    }

    @PostMapping("listBySid")
    public ResponseEntity<?> listDeviceBySid(@RequestBody DeviceBaseParam param) {
        List<Device> devices = deviceService.listDeviceBySid(param.getSid());
        return ResponseEntity.ok().body(devices);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateDevice(@RequestBody DeviceBaseParam param) {
        if (param.getDid() == null) {
            return ResponseEntity.badRequest().body("Device ID is required");
        }
        if (deviceService.updateDevice(param) > 0) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body("Update failed");
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertDevice(@RequestBody DeviceBaseParam param) {
        if (deviceService.insertDevice(param) > 0) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body("Insert failed");
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteDevice(@RequestBody DeviceBaseParam param) {
        if (deviceService.deleteDeviceById(param.getDid()) > 0) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body("Delete failed");
    }
}
