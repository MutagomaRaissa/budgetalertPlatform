package com.budgetalert.projectservice.service;

import com.budgetalert.projectservice.model.Project;
import com.budgetalert.projectservice.model.ProjectStatus;
import com.budgetalert.projectservice.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

//create,delete,update,read

public class ProjectService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);
private final ProjectRepository projectRepository;

 public  ProjectService(ProjectRepository projectRepository) {
  this.projectRepository = projectRepository;
 }
 public List<Project> findAll() {
     logger.info("Find All Projects");
  return projectRepository.findAll();
 }
 public Project findById(Long projectId) {
     logger.info("Getting project by id: " + projectId);
     return projectRepository.findById(projectId).orElseThrow(() -> {
         logger.error("Application not found for id: " + projectId);
         return new RuntimeException("Application not found");
     });
 }
public void deleteById(Long projectId) {
     logger.info("Deleting project by id: " + projectId);
     Project project = projectRepository.findById(projectId).orElseThrow(() ->
     { logger.error("Application not found for id: " + projectId);
         return new RuntimeException("Application not found"); });
     projectRepository.delete(project);

}
public Project save(Project project) {
     logger.info("Saving project : " + project);
     Project savedProject = projectRepository.save(project);
     return savedProject;
}
public Project update( Long projectId, Project project) {
     logger.info("Updating project : " + project);
     Project existingProject = findById(projectId);
     if  (existingProject == null) {
         logger.error("Application not found for id: " + projectId);
         throw new RuntimeException("Application not found for id: " + projectId);
     }
     existingProject.setName(project.getName());
     existingProject.setDescription(project.getDescription());
     existingProject.setStatus(project.getStatus());
     existingProject.setApplication_owner(project.getApplication_owner());
     existingProject.setCloud_provider(project.getCloud_provider());
     existingProject.setIto_provider(project.getIto_provider());
     existingProject.setMonthly_budget(project.getMonthly_budget());
     existingProject.setAnnual_budget(project.getAnnual_budget());
     existingProject.setMonthly_budget(project.getMonthly_budget());
     existingProject.setSubscription(project.getSubscription());
     existingProject.setResource_group(project.getResource_group());
     logger.info("Project updated successfully");
     return projectRepository.save(existingProject);

}


}
