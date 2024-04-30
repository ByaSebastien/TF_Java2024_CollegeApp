package be.bstorm.tf_java2024_collegeapp.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Student extends User {

    @Getter @Setter
    @Column(name = "CONTACT_PHONE_NUMBER",nullable = false,length = 20)
    private String contactPhoneNumber;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_GRADE")
    private Grade grade;
}
