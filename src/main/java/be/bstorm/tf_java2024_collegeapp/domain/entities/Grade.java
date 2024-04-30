package be.bstorm.tf_java2024_collegeapp.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Grade extends BaseEntity<Long>{

    @Getter @Setter
    @Column(name = "NAME",nullable = false,length = 50)
    private String name;

    @Getter @Setter
    @Column(name = "ACADEMIC_YEAR")
    private int academicYear;
}
