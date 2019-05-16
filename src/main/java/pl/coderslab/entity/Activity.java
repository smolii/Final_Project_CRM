package pl.coderslab.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activities")
@DynamicUpdate
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private LocalDateTime created;

	private String content;

	@ManyToOne
	@JoinColumn
	private User user;

	public Activity() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getInformation(Project project) {
		return "User " + user.getName() + " " + user.getSurname() + " created a project named \"" + " "
				+ project.getName() + "\".";
	}

	public String getInformation(Project project, Task task) {
		return "User " + user.getName() + " " + user.getSurname() + " added to project \"" + project.getName()
				+ "\" a task \"" + task.getSubject() + "\".";
	}

	public String getInformation(Task task, Status status) {
		return "User " + user.getName() + " " + user.getSurname() + " changed status of task \"" + " " + task.getSubject()
				+ "\" to \"" + status.getName() + "\".";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Activity other = (Activity) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", created=" + created + ", content=" + content + ", user=" + user + "]";
	}

}
