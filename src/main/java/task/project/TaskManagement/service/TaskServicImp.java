package task.project.TaskManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import task.project.TaskManagement.entities.TaskEntity;
import task.project.TaskManagement.model.TaskModel;
import task.project.TaskManagement.repository.TaskRepository;
import task.project.TaskManagement.transformers.TaskEntityToModelTransformer;
import task.project.TaskManagement.transformers.TaskModelToEntityTransformer;

@Service
public class TaskServicImp  implements TaskService{
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private TaskEntityToModelTransformer entityToModel;
	
	@Autowired
	private TaskModelToEntityTransformer modelToEntity;

	@Override
	public TaskModel getTaskById(Long id) {
		Optional<TaskEntity> taskEntity = taskRepo.findById(id);
			if(taskEntity.isPresent())
				return entityToModel.apply(taskEntity.get());
			else
				return null;
	}

	@Override
	public TaskModel saveTask(TaskModel task) {
		return entityToModel.apply(
					taskRepo.save(modelToEntity.apply(task)));
	}

	@Override
	public List<TaskModel> getAllTasks() {
		Iterable<TaskEntity> taskEntityList = taskRepo.findAll();
		
		if(taskEntityList == null) {
			return null;
		}
		
		List<TaskModel> taskModelList = new ArrayList<TaskModel>();
		for( TaskEntity taskEntity : taskEntityList) {
			taskModelList.add(entityToModel.apply(taskEntity));
		}
		return taskModelList;
	}

	@Override
	public boolean deleteTask(Long id) {
		Optional<TaskEntity> taskEntity = taskRepo.findById(id);
		if( taskEntity.isPresent()) {
			taskRepo.deleteById(id);
			return true;
		} else 
			return false;
	}	

	@Override
	public TaskModel updateTask(TaskModel taskModel) {
		if( taskModel == null)
			return null;
		Optional<TaskEntity> taskEntity = taskRepo.findById(taskModel.getId());
		if(taskEntity.isPresent()) {
			TaskEntity entity = taskRepo.save(modelToEntity.apply(taskModel));
			return entityToModel.apply(entity);
		}
		return null;
	}

}
