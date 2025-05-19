package task.project.TaskManagement.repository;

import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;
import task.project.TaskManagement.entities.PersonEntity;

@Transactional
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

}
