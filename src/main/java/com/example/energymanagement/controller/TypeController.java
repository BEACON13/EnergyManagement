package com.example.energymanagement.controller;

import com.example.energymanagement.model.param.TypeBaseParam;
import com.example.energymanagement.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @PostMapping("/listAllTypeNames")
    public ResponseEntity<?> listAllTypeNames() {
        return ResponseEntity.ok().body(typeService.listAllTypeNames());
    }

    @PostMapping("/listAllModel")
    public ResponseEntity<?> listAllModel(@RequestBody TypeBaseParam param) {
        if (param.getName() == null) {
            return ResponseEntity.badRequest().body("name is required");
        }
        return ResponseEntity.ok().body(typeService.listAllModel(param.getName()));
    }

    @PostMapping("/listAllTypes")
    public ResponseEntity<?> listAllTypes() {
        return ResponseEntity.ok().body(typeService.listAllTypes());
    }

}
