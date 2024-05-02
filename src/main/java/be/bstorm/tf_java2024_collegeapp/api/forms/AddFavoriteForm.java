package be.bstorm.tf_java2024_collegeapp.api.forms;

import be.bstorm.tf_java2024_collegeapp.domain.entities.StudentFavoriteCourse;
import jakarta.validation.constraints.Max;
import org.hibernate.validator.constraints.Range;

public record AddFavoriteForm(
        Long courseId,

        @Range(min = 0, max = 5)
        int rating
) {
}
