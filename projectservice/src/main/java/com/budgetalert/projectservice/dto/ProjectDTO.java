package com.budgetalert.projectservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDTO {


    private Long id;

    private long projectId;

    private String name;

    private String application_owner;

    private String description;

    private String subscription;

    private String resource_group;

    private String ito_provider;

    private String status;

    private String cloud_provider;

    private Double annual_budget;

    private Double monthly_budget;
}
