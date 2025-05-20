package task.project.TaskManagement.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PersonEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String name;
    private String surname;
    private String email;
    private LocalDate birthday;
    
    @Builder.Default
    @ManyToMany
    @JoinTable(
        name = "person_task",
        joinColumns = @JoinColumn(name = "person_id"),
        inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private Set<TaskEntity> tasks = new HashSet<>();

	public void addTask(TaskEntity taskEntity) {
		if(tasks == null){
			tasks =  new HashSet<>();
			tasks.add(taskEntity);
		}
	}
	
	public void removeTask(TaskEntity taskEntity) {
		tasks.remove( taskEntity);
	}

	
	

}
