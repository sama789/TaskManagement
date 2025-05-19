package task.project.TaskManagement.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

}
