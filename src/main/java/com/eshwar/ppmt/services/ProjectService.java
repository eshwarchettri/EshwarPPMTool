package com.eshwar.ppmt.services;

import com.eshwar.ppmt.domain.Project;
import com.eshwar.ppmt.exceptions.ProjectIdException;
import com.eshwar.ppmt.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectService {
    private ProjectRepository projectRepository;

    public Project saveProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project Identifier "+ project.getProjectIdentifier()+" already exists" );
        }
    }

    public Project getProjectByIdentifier(String identifier) {
        Optional<Project> project = projectRepository.findByProjectIdentifier(identifier);
        if (!project.isPresent()) {
            throw new ProjectIdException("Project identifier "+ identifier + " does not exists.");
        }
        return project.get();
    }

    public List<Project> getAllProject () {
        return projectRepository.findAll();
    }
    public void deleteProjectById(String projectId) {
        Optional<Project> project = projectRepository.findByProjectIdentifier(projectId);
        if (!project.isPresent()) {
            throw new ProjectIdException("Project identifier "+ projectId + " does not exists.");
        }
        projectRepository.deleteById(project.get().getId());

    }
}
