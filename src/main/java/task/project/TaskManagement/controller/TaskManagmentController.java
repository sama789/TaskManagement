package task.project.TaskManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskManagmentController {

	@GetMapping("/ping")
	public String ping() {
		return "Task Management's Ready to go ";
	}
}
