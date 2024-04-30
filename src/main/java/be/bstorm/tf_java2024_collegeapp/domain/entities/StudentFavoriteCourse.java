package be.bstorm.tf_java2024_collegeapp.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class StudentFavoriteCourse {

    @Getter
    @EmbeddedId
    private StudentFavoriteCourseId id;

    @ManyToOne
    @MapsId(value = "studentId")
    @Getter @Setter
    private Student student;

    @ManyToOne
    @MapsId(value = "courseId")
    @Getter @Setter
    private Course course;

    @Column(name = "RATE",nullable = false)
    @Getter @Setter
    private int rate;

    @Embeddable
    @Getter @Setter
    @EqualsAndHashCode
    @ToString
    public static class StudentFavoriteCourseId implements Serializable{

        @Column(name = "STUDENT_ID",nullable = false)
        private Long studentId;

        @Column(name = "COURSE_ID",nullable = false)
        private Long courseId;
    }
}
