package pl.coderslab.entity;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projects")
@DynamicUpdate
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(updatable=false)
	private LocalDateTime created;

	@Size(min=3)
	private String name;

	@Column(columnDefinition = "TEXT")
	private String description;

	@URL
	@Size(min=10)
	private String websiteUrl;

	private String identifier;

	private boolean isActive;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<User> users;

	@OneToMany(mappedBy = "project")
	private List<Task> tasks;
	
	@Transient
	private String niceDate;

	public Project() {
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
	

	public String getNiceDate() {
		setNiceDate();
		return niceDate;
	}

	public void setNiceDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		this.niceDate = getCreated().format(formatter);
	}
	public void setNiceDate(String niceDate) {
		this.niceDate = niceDate;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.getIdentifier();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		if (this.identifier == null||this.identifier=="") {
			this.identifier = identifier;
		}
	}

	public void setIdentifier() {
		String idRegex = "[żźćńółęąśŻŹĆĄŚĘŁÓŃ]";
		this.identifier = getName().trim().replaceAll(" ", "-").toLowerCase().replaceAll(idRegex, "");
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public void mergeFromEdit(Project project) {
		this.setDescription(project.getDescription());
		this.setName(project.getName());
		this.setWebsiteUrl(project.getWebsiteUrl());
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((niceDate == null) ? 0 : niceDate.hashCode());
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
		result = prime * result + ((websiteUrl == null) ? 0 : websiteUrl.hashCode());
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
		Project other = (Project) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (isActive != other.isActive)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (niceDate == null) {
			if (other.niceDate != null)
				return false;
		} else if (!niceDate.equals(other.niceDate))
			return false;
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
			return false;
		if (websiteUrl == null) {
			if (other.websiteUrl != null)
				return false;
		} else if (!websiteUrl.equals(other.websiteUrl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", created=" + created + ", name=" + name + ", description=" + description
				+ ", websiteUrl=" + websiteUrl + ", identifier=" + identifier + ", isActive=" + isActive + "]";
	}

}
