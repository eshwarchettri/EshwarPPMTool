package com.eshwar.ppmt.repositories;

import com.eshwar.ppmt.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    Optional<Project> findByProjectIdentifier(String projectId);
}
