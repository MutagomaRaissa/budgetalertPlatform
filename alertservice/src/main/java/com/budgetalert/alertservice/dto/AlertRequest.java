package com.budgetalert.alertservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertRequest {

    private String email;
    private String projectName;
    private Double totalCost;
    private Double percentage;
}
