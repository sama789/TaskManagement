package task.project.TaskManagement.transformers;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import task.project.TaskManagement.entities.PersonEntity;
import task.project.TaskManagement.model.PersonModel;


@Component
public class PersonEntityToModelTransformer implements Function<PersonEntity, PersonModel>{

	@Override
	public PersonModel apply(PersonEntity person) {
	
		if( person == null)
			return null;
		return PersonModel.builder()
				.id(person.getId())
				.name(person.getName())
				.surname(person.getSurname())
				.birthday(person.getBirthday())
				.email(person.getEmail())
				.build();
			}
	}


