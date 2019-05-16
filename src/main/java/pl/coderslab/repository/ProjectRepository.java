package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	@Query("select project from Project project where isActive = ?1")
	List<Project> findAllByActive(boolean active);
	
	List<Project> findTop5ByOrderByCreatedDesc();
	
}
