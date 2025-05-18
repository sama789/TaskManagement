package task.project.TaskManagement.transformers;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import task.project.TaskManagement.entities.TaskEntity;
import task.project.TaskManagement.model.TaskModel;

@Component
public class TaskEntityToModelTransformer implements Function<TaskEntity, TaskModel>{

	@Override
	public TaskModel apply(TaskEntity task) {
		if( task == null)
			return null;
		return TaskModel.builder()
				.id(task.getId())
				.description(task.getDescription())
				.date(task.getDate())
				.build();
	}

}
