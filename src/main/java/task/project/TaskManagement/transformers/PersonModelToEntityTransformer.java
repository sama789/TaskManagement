package task.project.TaskManagement.transformers;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import task.project.TaskManagement.entities.PersonEntity;
import task.project.TaskManagement.model.PersonModel;

@Component
public class PersonModelToEntityTransformer implements Function<PersonModel, PersonEntity>{

	@Override
	public PersonEntity apply(PersonModel person ) {
		if( person == null)
			return null;
		return PersonEntity.builder()
				.id(person.getId())
				.name(person.getName())
				.surname(person.getSurname())
				.birthday(person.getBirthday())
				.email(person.getEmail())
				.build();
	}

}
