package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	
	@Query("select task from Task task where activeUser_id = ?1")
	List<Task> findByActiveUserId(long id);
}
