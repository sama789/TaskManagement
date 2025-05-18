package task.project.TaskManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import task.project.TaskManagement.model.TaskModel;
import task.project.TaskManagement.service.TaskService;

@RestController
public class TaskManagmentController {
	
	@Autowired
	private TaskService taskService;

	@GetMapping("/ping")
	public String ping() {
		return "Task Management's Ready to go ";
	}
	
	//create
	@PostMapping("/newTask")
	public TaskModel createTask(@RequestBody TaskModel task) {
		return taskService.saveTask(task);
	}
	//Read 
	@GetMapping("/task/all")
	@SuppressWarnings({"rawtypes", "unchecked" })
	public ResponseEntity<List<TaskModel>> getAllTask(){
		
		List<TaskModel> allElements = taskService.getAllTasks();
		if( allElements != null) {
			return new ResponseEntity<List<TaskModel>>(allElements, HttpStatus.OK);
		}else
			return new ResponseEntity("No Elments have been found", HttpStatus.NOT_FOUND);
	}
	
	
	
	//Update
	@PutMapping("/taskUpdate")
	public ResponseEntity<TaskModel> updateTask(@RequestBody TaskModel task){
		TaskModel taskModel = taskService.updateTask(task);
		if( taskModel != null) {
			return new ResponseEntity<TaskModel>(taskModel, HttpStatus.OK);
		} else 
			return new ResponseEntity("No Element found", HttpStatus.NOT_FOUND);

	}
	//Delete 
	@DeleteMapping("/taskDelete")
	public ResponseEntity<String> deletTaskById(@RequestParam(value ="id") Long id){
		
		if(taskService.deleteTask(id)) {
			return new ResponseEntity<String>("Task with id: "+id + " has been delted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Element found", HttpStatus.NOT_FOUND);

		}
	}
	
	//getById
	@GetMapping("/taskget")
	@SuppressWarnings({"rawtypes", "unchecked" })
	public ResponseEntity<TaskModel> getTask(@RequestParam(value ="id") Long id){
		TaskModel taskModel = taskService.getTaskById(id);
		if(taskModel != null) {
			return new ResponseEntity<TaskModel>(taskModel, HttpStatus.OK);
		}
		else {
			return new ResponseEntity("No Task with Id has been found" + id, HttpStatus.NOT_FOUND );
		}
	}
}
