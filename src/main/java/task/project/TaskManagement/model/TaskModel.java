package task.project.TaskManagement.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import task.project.TaskManagement.enums.TaskStatus;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskModel {
	private Long id;

    private String description;

    private LocalDate date;
    
    private TaskStatus status;
}
