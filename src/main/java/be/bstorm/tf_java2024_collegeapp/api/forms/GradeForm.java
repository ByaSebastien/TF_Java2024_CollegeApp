package be.bstorm.tf_java2024_collegeapp.api.forms;

import be.bstorm.tf_java2024_collegeapp.domain.entities.Grade;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public record GradeForm(
        @NotBlank
        @Size(max = 50)
        String name,

        @Range(min = 1,max = 6,message = "${validatedValue} is not between between {min} and {max}")
        int academicYear
) {

    public Grade toEntity(){
        return new Grade(this.name,this.academicYear);
    }
}
