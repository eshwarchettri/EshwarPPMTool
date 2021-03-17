package com.eshwar.ppmt.controllers;

import com.eshwar.ppmt.domain.Project;
import com.eshwar.ppmt.services.MapErrorValidationService;
import com.eshwar.ppmt.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProjectController {

    private ProjectService projectService;
    private MapErrorValidationService mapErrorValidationService;

    @PostMapping("/save-project")
    private ResponseEntity<?> saveProject(@Valid @RequestBody Project project, BindingResult result) {
        if (result.hasErrors()) {
            return mapErrorValidationService.getMapErrorsValidation(result.getFieldErrors());
        }
        Project project1 = projectService.saveProject(project);
        return new ResponseEntity<>(project1, HttpStatus.CREATED);
    }

    @GetMapping("/get-project/{projectId}")
    private ResponseEntity<?> getProject(@PathVariable String projectId) {
        return new ResponseEntity<>(projectService.getProjectByIdentifier(projectId), HttpStatus.OK);
    }

    @GetMapping("/get-all-projects")
    private ResponseEntity<?> getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProject(), HttpStatus.OK);
    }

    @DeleteMapping("/delete-project/{projectId}")
    public ResponseEntity<?> deleteProject (@PathVariable String projectId) {
        projectService.deleteProjectById(projectId);
     return new ResponseEntity<>("Project with Identifier '" + projectId + "' was deleted successfully.", HttpStatus.OK );
    }

    @PutMapping("/update-project")
    public ResponseEntity<?> updateProject(@Valid @RequestBody Project project, BindingResult result) {
        if (result.hasErrors()) {
            return mapErrorValidationService.getMapErrorsValidation(result.getFieldErrors());
        }
        Project project1 = projectService.saveProject(project);
        return new ResponseEntity<>(project1, HttpStatus.CREATED);
    }
}
