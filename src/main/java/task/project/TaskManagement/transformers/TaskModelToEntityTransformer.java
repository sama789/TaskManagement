package task.project.TaskManagement.transformers;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import task.project.TaskManagement.entities.TaskEntity;
import task.project.TaskManagement.model.TaskModel;

@Component
public class TaskModelToEntityTransformer implements Function<TaskModel ,TaskEntity> {

	@Override
	public TaskEntity apply(TaskModel task) {
		if( task == null)
			return null;
		return TaskEntity.builder()
				.id(task.getId())
				.description(task.getDescription())
				.date(task.getDate())
				.status(task.getStatus())
				.build();
	}

}
