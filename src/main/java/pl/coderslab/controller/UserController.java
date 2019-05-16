package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.Task;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TaskRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TaskRepository taskRepo;


	@GetMapping(path = "")
	public String userMainPage(Model model, HttpSession session, @RequestParam(name = "par", required = false) String msg) {
		if (msg != null) {
			if (msg.equals("succPass")) {
				model.addAttribute("message", "You have successfully changed Your password");
			}
			if (msg.equals("editSucc")) {
				model.addAttribute("message", "You have successfully edited user's data!");
			}
//
		}
		long loggedUserId = (long) session.getAttribute("loggedUser");
		User loggedUser = userRepo.findOne(loggedUserId);
		model.addAttribute("currentUser", loggedUser);
		Set<Project> userProjects = loggedUser.getProjects();
		model.addAttribute("myProjects", userProjects);
		List<Task> userTasks = taskRepo.findByActiveUserId(loggedUserId);
		model.addAttribute("myTasks", userTasks);
		return "user/main";
	}
	
	@GetMapping(path = "/myProjects")
	public String UserProjects(Model model, HttpSession session) {
		long loggedUserId = (long) session.getAttribute("loggedUser");
		User loggedUser = userRepo.findOne(loggedUserId);
		model.addAttribute("currentUser", loggedUser);
		Set<Project> userProjects = loggedUser.getProjects();
		model.addAttribute("myProjects", userProjects);
		return "user/myProjects";
	}
	
	@GetMapping(path = "/myTasks")
	public String UserTask(Model model, HttpSession session) {
		long loggedUserId = (long) session.getAttribute("loggedUser");
		User loggedUser = userRepo.findOne(loggedUserId);
		model.addAttribute("currentUser", loggedUser);
		List<Task> userTasks = taskRepo.findByActiveUserId(loggedUserId);
		model.addAttribute("myTasks", userTasks);
		return "user/myTasks";
	}

	@GetMapping(path = "/edit")
	public String editUser(Model model, HttpSession session) {
		long loggedUserId = (long) session.getAttribute("loggedUser");
		User userToEdit = userRepo.findOne(loggedUserId);
		model.addAttribute("user", userToEdit);
		return "user/edit";
	}

	@PostMapping(path = "/edit")
	public String editUserPost(@ModelAttribute User user, Model model, HttpSession session) {
		model.addAttribute("par", "editSucc");
		long loggedUserId = (long) session.getAttribute("loggedUser");
		User merged = userRepo.findOne(loggedUserId);
		merged.mergeFromEdit(user);
		userRepo.save(merged);
		return "redirect:/user";
	}


}
