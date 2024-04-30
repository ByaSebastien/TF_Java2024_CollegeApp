package be.bstorm.tf_java2024_collegeapp.api.forms;

import be.bstorm.tf_java2024_collegeapp.domain.entities.Course;
import jakarta.validation.constraints.*;

public record CourseForm(
        @NotBlank(message = "Name cannot be blank")
        @Size(max = 50)
        String name,
        @NotBlank
        @Size(max = 200)
        String summary,

        @Min(value = 1,message = "academic year must be between 1 and 6") @Max(value = 6,message = "academic year must be between 1 and 6")
        int academicYear
) {

    public Course toEntity(){
        return new Course(this.name,this.summary,this.academicYear);
    }
}
