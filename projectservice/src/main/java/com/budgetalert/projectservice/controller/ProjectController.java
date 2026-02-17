package com.budgetalert.projectservice.controller;

import com.budgetalert.projectservice.dto.ProjectDTO;
import com.budgetalert.projectservice.model.Project;
import com.budgetalert.projectservice.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService service;

    @PostMapping
    public Project create(@RequestBody ProjectDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<Project> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Project update(@PathVariable Long id, @RequestBody ProjectDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
