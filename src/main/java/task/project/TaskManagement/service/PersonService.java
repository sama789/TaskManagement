package task.project.TaskManagement.service;

import java.util.List;

import task.project.TaskManagement.model.PersonModel;


public interface PersonService {
	
	public PersonModel getPersonById(Long id);
	public PersonModel savePerson(PersonModel person);
	public List<PersonModel> getAllPersons();
	public boolean deletePerson(Long id);
	public PersonModel updatePerson(PersonModel person);
	

}
