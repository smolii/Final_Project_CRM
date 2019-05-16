package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Activity;


import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{

    List<Activity> findTop25ByOrderByCreatedDesc();
	
}
