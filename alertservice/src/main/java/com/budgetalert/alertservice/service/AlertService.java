package com.budgetalert.alertservice.service;

import com.budgetalert.alertservice.dto.AlertRequest;
import com.budgetalert.alertservice.model.Alert;
import com.budgetalert.alertservice.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository repository;

    public void createAlert(AlertRequest request) {

        Alert alert = Alert.builder()
                .email(request.getEmail())
                .projectName(request.getProjectName())
                .totalCost(request.getTotalCost())
                .percentage(request.getPercentage())
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(alert);

        // You can later add email sending here
        System.out.println("ALERT TRIGGERED for: " + request.getEmail());
    }
}
