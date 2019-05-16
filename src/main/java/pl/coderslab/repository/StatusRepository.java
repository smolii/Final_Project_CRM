package pl.coderslab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Status;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{

	@Query("select status from Status status where isActive = ?1")
	List<Status> findAllByActive(boolean active);
}
