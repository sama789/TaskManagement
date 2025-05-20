package task.project.TaskManagement.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import task.project.TaskManagement.enums.TaskStatus;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TaskEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String description;

    private LocalDate date;
    
    @Enumerated(EnumType.STRING) 
    private TaskStatus status;
    
    @ManyToMany(mappedBy= "tasks")
    private List<PersonEntity> persons;
    
    
    public void addPerson(PersonEntity personEntity) {
		if(persons == null) {
			persons = new ArrayList<>();
			persons.add(personEntity);
			personEntity.addTask(this);
		}
	}
    

}
