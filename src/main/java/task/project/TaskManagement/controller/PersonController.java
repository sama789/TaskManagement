package task.project.TaskManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import task.project.TaskManagement.model.PersonModel;
import task.project.TaskManagement.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/ping/person")
	public String pingPerson() {
		return "PersonContoller's working well ";
	}
	
	@PostMapping("/newPerson")
	public PersonModel createTask(@RequestBody PersonModel person) {
		return personService.savePerson(person);
	}

	@GetMapping("/person/all")
	@SuppressWarnings({"rawtypes", "unchecked" })
	public ResponseEntity<List<PersonModel>> getAllPersons(){
		
		List<PersonModel> personList = personService.getAllPersons();
		if(personList != null) {
			
			return new ResponseEntity<List<PersonModel>>(personList, HttpStatus.OK);
			}else {
				return new ResponseEntity("No Person have been found", HttpStatus.NOT_FOUND);
				}
			}
	
	@PutMapping("/personUpdate")
	public ResponseEntity<PersonModel> updatePerson(@RequestBody PersonModel person){
		PersonModel personModel = personService.updatePerson(person);
		if( personModel != null) {
			return new ResponseEntity<PersonModel>(personModel, HttpStatus.OK);
		} else 
			return new ResponseEntity("No Person ", HttpStatus.NOT_FOUND);

	}
	
	//Delete 
		@DeleteMapping("/personDelete")
		public ResponseEntity<String> deletPersonById(@RequestParam(value ="id") Long id){
			
			if(personService.deletePerson(id)) {
				return new ResponseEntity<String>("Person with id: "+id + " has been delted", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No Element foundPerson has been Found", HttpStatus.NOT_FOUND);

			}
		}
	
		
		@GetMapping("/persongetById")
		@SuppressWarnings({"rawtypes", "unchecked" })
		public ResponseEntity<PersonModel> getPersonById(@RequestParam(value ="id") Long id){
			PersonModel personModel = personService.getPersonById(id);
			if(personModel != null) {
				return new ResponseEntity<PersonModel>(personModel, HttpStatus.OK);
			}
			else {
				return new ResponseEntity("No Person with Id has been found" + id, HttpStatus.NOT_FOUND );
			}
		}
	
	
}
