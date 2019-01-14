package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Project;



public interface ProjectRepository extends JpaRepository<Project, Long> {


}