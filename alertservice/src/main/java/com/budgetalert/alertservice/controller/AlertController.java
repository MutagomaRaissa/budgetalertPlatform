package com.budgetalert.alertservice.controller;

import com.budgetalert.alertservice.dto.AlertRequest;
import com.budgetalert.alertservice.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService service;

    @PostMapping
    public void receiveAlert(@RequestBody AlertRequest request) {
        service.createAlert(request);
    }
}
