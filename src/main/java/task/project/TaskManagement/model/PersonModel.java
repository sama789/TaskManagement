package task.project.TaskManagement.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonModel {
	
        private Long id; 
	    private String name;
	    private String surname;
	    private String email;
	    private LocalDate birthday;
	    private List<TaskModel> tasks;


}
