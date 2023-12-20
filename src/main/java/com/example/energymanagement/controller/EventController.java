package com.example.energymanagement.controller;

import com.example.energymanagement.model.param.EnergyUseParam;
import com.example.energymanagement.model.vo.EnergyBillVO;
import com.example.energymanagement.model.vo.EnergyDailyUseVO;
import com.example.energymanagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/listEnergyDailyUseByLocation")
    public ResponseEntity<?> listEnergyDailyUse(@RequestBody EnergyUseParam param) {
        if (param.getSid() == null || param.getStartDate() == null || param.getEndDate() == null) {
            return ResponseEntity.badRequest().body("Invalid parameter");
        }
        List<EnergyDailyUseVO> vos = eventService.listEnergyDailyUseBySid(param.getSid(), param.getStartDate(), param.getEndDate());
        if (vos == null) {
            return ResponseEntity.badRequest().body("No data");
        }
        return ResponseEntity.ok().body(vos);
    }

    @PostMapping("/listEnergyTimeUseByLocation")
    public ResponseEntity<?> listEnergyTimeUse(@RequestBody EnergyUseParam param) {
        if (param.getSid() == null || param.getStartDate() == null) {
            return ResponseEntity.badRequest().body("Invalid parameter");
        }
        List<EnergyDailyUseVO> vos = eventService.listEnergyTimeUseBySid(param.getSid(), param.getStartDate());
        if (vos == null) {
            return ResponseEntity.badRequest().body("No data");
        }
        return ResponseEntity.ok().body(vos);
    }

    @PostMapping("/listEnergyBillByLocation")
    public ResponseEntity<?> listEnergyBill(@RequestBody EnergyUseParam param) {
        if (param.getSid() == null || param.getStartDate() == null || param.getEndDate() == null) {
            return ResponseEntity.badRequest().body("Invalid parameter");
        }
        List<EnergyBillVO> vos = eventService.listEnergyBillBySid(param.getSid(), param.getStartDate(), param.getEndDate());
        if (vos == null) {
            return ResponseEntity.badRequest().body("No data");
        }
        return ResponseEntity.ok().body(vos);
    }

    @PostMapping("/listEnergyBillByDevice")
    public ResponseEntity<?> listEnergyBillByDevice(@RequestBody EnergyUseParam param) {
        if (param.getDid() == null || param.getSid() == null || param.getStartDate() == null || param.getEndDate() == null) {
            return ResponseEntity.badRequest().body("Invalid parameter");
        }
        List<EnergyBillVO> vos = eventService.listEnergyBillByDid(param.getSid(), param.getDid(), param.getStartDate(), param.getEndDate());
        if (vos == null) {
            return ResponseEntity.badRequest().body("No data");
        }
        return ResponseEntity.ok().body(vos);
    }

}
