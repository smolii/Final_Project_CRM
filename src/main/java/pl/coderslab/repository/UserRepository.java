package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import pl.coderslab.entity.User;

@Controller
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select user from User user where login = ?1")
	User findByLogin(String login);
}
