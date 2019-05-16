package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Priority;


import java.util.List;

@Repository

public interface PriorityRepository extends JpaRepository<Priority, Long>{

	
	@Query("select priority from Priority priority where isActive = ?1")
	List<Priority> findAllByActive(boolean active);
	
}
