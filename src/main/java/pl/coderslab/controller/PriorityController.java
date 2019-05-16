package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Priority;
import pl.coderslab.repository.PriorityRepository;

@Controller
@RequestMapping(path = "/priority")
public class PriorityController {

	@Autowired
	private PriorityRepository priorityRepo;
	
	@GetMapping(path = "")
	public String mainPriorirty(Model model, @RequestParam(name="par", required=false) String msg) {
		model.addAttribute("priorities", priorityRepo.findAllByActive(true));
		if (msg!=null) {
			if (msg.equals("succ")) {
				model.addAttribute("message", "You have successfully edited a priority!");
			} 
			if (msg.equals("del")){
				model.addAttribute("message", "You have successfully deleted a priority!");
			}
			if (msg.equals("adds")){
				model.addAttribute("message","You have successfully created a new priority!");
			}
		}
		return "priority/main";
	}
	
	@GetMapping(path = "/add")
	public String addNewPriorirty(Model model) {
		model.addAttribute("priority", new Priority());
		return "priority/add";
	}

	@PostMapping(path = "/add")
	public String addNewPriorirtyPost(@ModelAttribute Priority priority, Model model) {
		model.addAttribute("par", "adds");
		priority.setActive(true);
		priorityRepo.save(priority);
		return "redirect:/priority";
	}
	
	@GetMapping(path = "/delete/{id}")
	public String deletePriorirty(Model model, @PathVariable("id") long id) {
		model.addAttribute("par", "del");
		Priority prior = priorityRepo.findOne(id);
		prior.setActive(false);
		priorityRepo.save(prior);
		return "redirect:/priority";
	}
	@GetMapping(path = "/edit/{id}")
	public String editPriorirty(Model model, @PathVariable("id") long id) {
		model.addAttribute("priority", priorityRepo.findOne(id));
		return "priority/edit";
	}

	@PostMapping(path = "/edit/{id}")
	public String editPriorirtyPost(@ModelAttribute Priority priority, Model model) {
		model.addAttribute("par", "succ");
		priority.setActive(true);
		priorityRepo.save(priority);
		return "redirect:/priority";
	}
}
