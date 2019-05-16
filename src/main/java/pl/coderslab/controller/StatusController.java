package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Status;
import pl.coderslab.repository.StatusRepository;

@Controller
@RequestMapping(path = "/status")
public class StatusController {

	@Autowired
	private StatusRepository statusRepo;
	
	@GetMapping(path = "")
	public String mainStatus(Model model, @RequestParam(name="par", required=false) String msg) {
		model.addAttribute("statuses", statusRepo.findAllByActive(true));
		if (msg!=null) {
			if (msg.equals("succ")) {
				model.addAttribute("message", "You have successfully edited a status!");
			} 
			if (msg.equals("del")){
				model.addAttribute("message", "You have successfully deleted a status!");
			}
			if (msg.equals("adds")){
				model.addAttribute("message","You have successfully created a new status!");
			}
		}
		return "status/main";
	}
	
	@GetMapping(path = "/add")
	public String addNewStatus(Model model) {
		model.addAttribute("status", new Status());
		return "status/add";
	}

	@PostMapping(path = "/add")
	public String addNewStatusPost(@ModelAttribute Status status, Model model) {
		model.addAttribute("par", "adds");
		status.setActive(true);
		statusRepo.save(status);
		return "redirect:/status";
	}
	
	@GetMapping(path = "/delete/{id}")
	public String deleteStatus(Model model, @PathVariable("id") long id) {
		model.addAttribute("par", "del");
		Status status = statusRepo.findOne(id);
		status.setActive(false);
		statusRepo.save(status);
		return "redirect:/status";
	}
	@GetMapping(path = "/edit/{id}")
	public String editStatus(Model model, @PathVariable("id") long id) {
		model.addAttribute("status", statusRepo.findOne(id));
		return "status/edit";
	}

	@PostMapping(path = "/edit/{id}")
	public String editStatusPost(@ModelAttribute Status status, Model model) {
		model.addAttribute("par", "succ");
		status.setActive(true);
		statusRepo.save(status);
		return "redirect:/status";
	}
}
