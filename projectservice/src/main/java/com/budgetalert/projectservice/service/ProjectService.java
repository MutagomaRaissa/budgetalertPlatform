package com.budgetalert.projectservice.service;

import com.budgetalert.projectservice.client.CoverageClient;
import com.budgetalert.projectservice.dto.ProjectDTO;
import com.budgetalert.projectservice.model.Project;
import com.budgetalert.projectservice.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository repository;
    private final CoverageClient coverageClient;

    public Project create(ProjectDTO dto) {

        Project project = new Project();
        BeanUtils.copyProperties(dto, project);

        Project saved = repository.save(project);

        // Trigger coverage calculation
        coverageClient.calculateCoverage(saved.getId());

        return saved;
    }

    public List<Project> getAll() {
        return repository.findAll();
    }

    public Project getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public Project update(Long id, ProjectDTO dto) {
        Project project = getById(id);
        BeanUtils.copyProperties(dto, project);
        return repository.save(project);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
