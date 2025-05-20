package task.project.TaskManagement.transformers;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import task.project.TaskManagement.entities.PersonEntity;
import task.project.TaskManagement.model.PersonModel;


@Component
public class PersonEntityToModelTransformer implements Function<PersonEntity, PersonModel>{

	@Autowired
    private TaskEntityToModelTransformer taskTransformer;
	
	public PersonEntityToModelTransformer(@Lazy TaskEntityToModelTransformer taskTransformer) {
        this.taskTransformer = taskTransformer;
    }
	
	@Override
    public PersonModel apply(PersonEntity person) {
        if (person == null) return null;

        return PersonModel.builder()
                .id(person.getId())
                .name(person.getName())
                .surname(person.getSurname())
                .birthday(person.getBirthday())
                .email(person.getEmail())
                .tasks(person.getTasks() != null
                        ? person.getTasks().stream()
                            .map(taskTransformer)
                            .collect(Collectors.toList())
                        : null)
                .build();
    }
	
	}


