package task.project.TaskManagement.repository;

import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;
import task.project.TaskManagement.entities.TaskEntity;

@Transactional
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {

}
