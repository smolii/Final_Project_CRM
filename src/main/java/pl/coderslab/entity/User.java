package pl.coderslab.entity;

import org.hibernate.annotations.DynamicUpdate;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@DynamicUpdate
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true, nullable = false)
	@NotNull
	@Size(min=3, message="Login should be at least 3 characters long")
	private String login;

	@NotNull
	@Column(nullable = false)
	@Size(min=3, message="Name should be at least 3 characters long")
	private String name;

	@NotNull
	@Column(nullable = false)
	@Size(min=3, message="Surname should be at least 3 characters long")
	private String surname;

	@NotNull
	@Column(nullable = false)
	@Size(min=50,  message="Password cannot be empty")
	private String password;
	
	@ManyToOne
	@JoinColumn
	private UserRole userRole;

	@OneToMany(mappedBy = "activeUser")
	private List<Task> tasks;

	@OneToMany(mappedBy = "user")
	private List<Activity> activities;

	@ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
	private Set<Project> projects;

	public User() {
		super();
	}

	public User(long id, String login, String name, String surname, String password, UserRole userRole) {
		super();
		this.id = id;
		this.login = login;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.userRole = userRole;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activities == null) ? 0 : activities.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (activities == null) {
			if (other.activities != null)
				return false;
		} else if (!activities.equals(other.activities))
			return false;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}

	public void mergeFromEdit(User user) {
		this.setName(user.getName());
		this.setSurname(user.getSurname());
		this.setLogin(user.getLogin());
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", name=" + name + ", surname=" + surname + "]";
	}

}
