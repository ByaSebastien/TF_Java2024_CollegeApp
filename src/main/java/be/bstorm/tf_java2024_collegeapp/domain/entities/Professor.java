package be.bstorm.tf_java2024_collegeapp.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Professor extends User {

    @Getter @Setter
    @Column(name = "TITLE",nullable = false,length = 50)
    private String title;

    @Getter @Setter
    @Column(name = "IS_APPOINTED",nullable = false)
    private boolean isAppointed;
}
