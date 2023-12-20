package com.example.energymanagement.controller;

import com.example.energymanagement.model.param.EnergyDailyUseParam;
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
@RequestMapping("/energy")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/listEnergyDailyUse")
    public ResponseEntity<?> listEnergyDailyUse(@RequestBody EnergyDailyUseParam param) {
        List<EnergyDailyUseVO> vos = eventService.listEnergyDailyUseByTid(param.getSid(), param.getStartDate(), param.getEndDate());
        if (vos == null) {
            return ResponseEntity.badRequest().body("No data");
        }
        return ResponseEntity.ok().body(vos);
    }

}
