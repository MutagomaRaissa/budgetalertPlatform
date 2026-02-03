package com.budgetalert.projectservice.model;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="projects")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "project_id")
    private long projectId;

    @Column(name= "project_name")
    private String name;

    @Column(name= "project_owner")
    private String application_owner;

    @Column(name = "description")
    private String description;

    @Column(name = "subscription")
    private String subscription;

    @Column(name = "resource_group")
    private String resource_group;

    @Column(name = "ito_provider")
    private String ito_provider;

    @Column(name = "status")
    private ProjectStatus status= ProjectStatus.New;

    @Column(name = "cloud_provider")
    private String cloud_provider;

    @Column(name = "annual_budget")
    private Double annual_budget;

    @Column(name = "monthly_budget")
    private Double monthly_budget;

}
