package task.project.TaskManagement.transformers;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import task.project.TaskManagement.entities.TaskEntity;
import task.project.TaskManagement.model.TaskModel;
import task.project.TaskManagement.model.PersonModel;

@Component
public class TaskEntityToModelTransformer implements Function<TaskEntity, TaskModel>{
	
	 @Autowired
	 private PersonEntityToModelTransformer personTransformer;

	 
	 @Override
	 public TaskModel apply(TaskEntity task) {
	     if (task == null) return null;

	     List<PersonModel> personModels = (task.getPersons() == null) ? 
	         Collections.emptyList() : 
	         task.getPersons().stream()
	             .map(personTransformer)
	             .collect(Collectors.toList());

	     return TaskModel.builder()
	             .id(task.getId())
	             .description(task.getDescription())
	             .date(task.getDate())
	             .status(task.getStatus())
	             .persons(personModels)
	             .build();
	 }

	
}
