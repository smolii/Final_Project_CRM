package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Activity;


public interface ActivityRepository extends JpaRepository<Activity, Long> {

}