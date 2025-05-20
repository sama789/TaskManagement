package task.project.TaskManagement.transformers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task.project.TaskManagement.entities.PersonEntity;
import task.project.TaskManagement.entities.TaskEntity;
import task.project.TaskManagement.model.PersonModel;


@Component
public class PersonModelToEntityTransformer implements Function<PersonModel, PersonEntity>{
	
	@Autowired
	private TaskModelToEntityTransformer taskTransformer;

	@Override
    public PersonEntity apply(PersonModel personModel) {
        if (personModel == null) return null;

        PersonEntity personEntity = PersonEntity.builder()
                .id(personModel.getId())
                .name(personModel.getName())
                .surname(personModel.getSurname())
                .birthday(personModel.getBirthday())
                .email(personModel.getEmail())
                .build();

        if (personModel.getTasks() != null) {
            Set<TaskEntity> tasks = personModel.getTasks().stream()
                .map(taskModel -> {
                    TaskEntity taskEntity = taskTransformer.apply(taskModel);
                    taskEntity.addPerson(personEntity); // bidirectional helper
                    return taskEntity;
                })
                .collect(Collectors.toSet());
            personEntity.setTasks( new HashSet<>(tasks));
        }

        return personEntity;
    }


}
