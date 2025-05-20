package task.project.TaskManagement.transformers;

import java.util.ArrayList;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import task.project.TaskManagement.entities.PersonEntity;
import task.project.TaskManagement.entities.TaskEntity;
import task.project.TaskManagement.model.TaskModel;

@Component
public class TaskModelToEntityTransformer implements Function<TaskModel ,TaskEntity> {
	
	@Autowired
    private PersonModelToEntityTransformer personModelToEntityTransformer;

	@Override
    public TaskEntity apply(TaskModel model) {
        if (model == null) return null;

        TaskEntity taskEntity = TaskEntity.builder()
                .id(model.getId())
                .description(model.getDescription())
                .date(model.getDate())
                .build();

        // Transform and assign persons
        if (model.getPersons() != null && !model.getPersons().isEmpty()) {
            Set<PersonEntity> persons = model.getPersons().stream()
                    .map(personModelToEntityTransformer)
                    .peek(personEntity -> personEntity.getTasks().add(taskEntity)) 
                    .collect(Collectors.toSet());

            taskEntity.setPersons(new ArrayList<>(persons));
        }

        return taskEntity;
    }
}
