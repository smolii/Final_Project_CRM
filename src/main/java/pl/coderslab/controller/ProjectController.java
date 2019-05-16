package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Activity;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.Task;
import pl.coderslab.entity.User;
import pl.coderslab.repository.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(path = "/project")
public class ProjectController {

	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private ProjectRepository projectRepo;

	@Autowired
	private ActivityRepository activityRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PriorityRepository priorityRepo;

	@Autowired
	private StatusRepository statusRepo;

	@GetMapping(path = "")
	public String mainProject(Model model, @RequestParam(name = "par", required = false) String msg) {
		model.addAttribute("projects", projectRepo.findAllByActive(true));
		if (msg != null) {
			if (msg.equals("succ")) {
				model.addAttribute("message", "You have successfully edited a project!");
			}
			if (msg.equals("del")) {
				model.addAttribute("message", "You have successfully deleted a project!");
			}
			if (msg.equals("adds")) {
				model.addAttribute("message", "You have successfully created a new project!");
			}
		}
		return "project/main";
	}

	@GetMapping(path = "/add")
	public String addNewProject(Model model) {
		model.addAttribute("project", new Project());
		return "project/add";
	}

	@PostMapping(path = "/add")
	public String addNewProjectPost(@ModelAttribute Project project, Model model, HttpSession session) {
		model.addAttribute("par", "adds");
		project.setActive(true);
		project.setCreated(LocalDateTime.now());
		project.setIdentifier();
		Set <User> projectUser = new HashSet<>();
		User user = userRepo.findOne((Long) session.getAttribute("loggedUser"));
		projectUser.add(user);
		project.setUsers(projectUser);
		Set<Project> projectsOfUser = user.getProjects();
		projectsOfUser.add(project);
		userRepo.save(user);
		projectRepo.save(project);

		try {
			Activity activity = new Activity();
			activity.setCreated(LocalDateTime.now());
			activity.setUser(user);
			String msg = activity.getInformation(project);
			activity.setContent(msg);
			activityRepo.save(activity);

		} catch (Exception e) {
			System.out.println("No logged user ERRO ERROR ERROR");
		}

		return "redirect:/user/myProjects";
	}

	@GetMapping(path = "/delete/{id}")
	public String deleteProject(Model model, @PathVariable("id") long id) {
		model.addAttribute("par", "del");
		Project project = projectRepo.findOne(id);
		project.setActive(false);
		projectRepo.save(project);
		return "redirect:/project";
	}

	@GetMapping(path = "/edit/{id}")
	public String editProject(Model model, @PathVariable("id") long id) {
		model.addAttribute("myProject", projectRepo.findOne(id));
		return "project/edit";
	}

	@PostMapping(path = "/edit/{id}")
	public String editProjectPost(@ModelAttribute Project myProject, Model model , @PathVariable("id") long id) {
		model.addAttribute("par", "succ");
		Project project = projectRepo.findOne(id);
		project.mergeFromEdit(myProject);
		project.setIdentifier();
		projectRepo.save(project);
		return "redirect:/user/myProjects";
	}

	@GetMapping(path = "/addTask/{id}")
	public String addTaskToProject(Model model, @PathVariable("id") long id) {
		model.addAttribute("myProject", projectRepo.findOne(id));
		model.addAttribute("task", new Task());
		model.addAttribute("projects", projectRepo.findAll());
		model.addAttribute("users", userRepo.findAll());
		model.addAttribute("statuses", statusRepo.findAll());
		model.addAttribute("priorities", priorityRepo.findAll());
		return "project/addTask";
	}

	@PostMapping(path = "/addTask/{id}")
	public String addTaskToProjectPost(@ModelAttribute Task task, Model model, HttpSession session, @PathVariable("id") long id) {
		Project project = projectRepo.findOne(id);
		task.setProject(project);
		task.setCreated(LocalDateTime.now());
		taskRepo.save(task);
		Set<User> projectUsers = project.getUsers();
		projectUsers.add(task.getActiveUser());
		projectRepo.save(project);
		
		try {
			User user = userRepo.findOne((Long) session.getAttribute("loggedUser"));
			Activity activity = new Activity();
			activity.setCreated(LocalDateTime.now());
			activity.setUser(user);
			String msg = activity.getInformation(project, task);
			activity.setContent(msg);
			activityRepo.save(activity);
			
		} catch (Exception e) {
			System.out.println("No logged user ERRO ERROR ERROR");
		}
		return "redirect:/user";
	}
}
