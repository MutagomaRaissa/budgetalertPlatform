package com.budgetalert.projectservice.model;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="projects")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String applicationOwner;

    private String email;

    private String description;

    private String cloudProvider;

    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    // Example: GB of RAM or Storage
    private Double resourceSizeGb;

    private Double monthlyBudget;

    private Double budgetThresholdPercentage = 80.0;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status = ProjectStatus.NEW;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.status = ProjectStatus.ACTIVE;
    }
}