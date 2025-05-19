package task.project.TaskManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import task.project.TaskManagement.entities.PersonEntity;
import task.project.TaskManagement.model.PersonModel;
import task.project.TaskManagement.repository.PersonRepository;
import task.project.TaskManagement.transformers.PersonEntityToModelTransformer;
import task.project.TaskManagement.transformers.PersonModelToEntityTransformer;

@Service
public class PersonServiceImp  implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PersonEntityToModelTransformer entityToModel;
	
	@Autowired
	private PersonModelToEntityTransformer modelToEntity;

	@Override
	public PersonModel getPersonById(Long id) {
		Optional<PersonEntity> personEntity = personRepository.findById(id);
		if(personEntity.isPresent())
			return entityToModel.apply(personEntity.get());
		else
			return null;
	}

	@Override
	public PersonModel savePerson(PersonModel person) {
		return entityToModel.apply(
				personRepository.save(modelToEntity.apply(person)));
	}

	@Override
	public List<PersonModel> getAllPersons() {
		Iterable<PersonEntity> personEntityList = personRepository.findAll();
		
		if(personEntityList == null) {
			return null;
		}
		
		List<PersonModel> personModelList = new ArrayList<PersonModel>();
		for( PersonEntity personEntity : personEntityList) {
			personModelList.add(entityToModel.apply(personEntity));
		}
		return personModelList;
	}

	@Override
	public boolean deletePerson(Long id) {
		Optional<PersonEntity> personEntity = personRepository.findById(id);
		if( personEntity.isPresent()) {
			personRepository.deleteById(id);
			return true;
		} else 
			return false;
	}

	@Override
	public PersonModel updatePerson(PersonModel person) {
		if( person == null)
			return null;
		
		Optional<PersonEntity> personEntity = personRepository.findById(person.getId());
		if(personEntity.isPresent()) {
			PersonEntity entity = personRepository.save(modelToEntity.apply(person));
			return entityToModel.apply(entity);
		}
		return null;
	}

}
