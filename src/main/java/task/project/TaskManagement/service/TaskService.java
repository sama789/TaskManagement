package task.project.TaskManagement.service;

import java.util.List;

import task.project.TaskManagement.model.TaskModel;

public interface TaskService {
	public TaskModel getTaskById(Long id);
	public TaskModel saveTask(TaskModel task);
	public List<TaskModel> getAllTasks();
	public boolean deleteTask(Long id);
	public TaskModel updateTask(TaskModel task);
	

}
