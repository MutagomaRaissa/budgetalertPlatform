package com.budgetalert.projectservice.dto;

import com.budgetalert.projectservice.model.ProjectStatus;
import com.budgetalert.projectservice.model.ResourceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDTO {


    private String name;
    private String applicationOwner;
    private String email;
    private String description;
    private String cloudProvider;
    private ResourceType resourceType;   // COMPUTE, STORAGE, NETWORK
    private Double resourceSizeGb;       // GB of RAM or storage
    private Double monthlyBudget;        // e.g., 1200.0

    // Optional: let client override defaults
    private Double budgetThresholdPercentage; // default 80.0
    private ProjectStatus status;
    }


