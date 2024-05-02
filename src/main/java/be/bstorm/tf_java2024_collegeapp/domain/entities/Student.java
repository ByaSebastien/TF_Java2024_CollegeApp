package be.bstorm.tf_java2024_collegeapp.domain.entities;

import be.bstorm.tf_java2024_collegeapp.domain.enums.UserGender;
import be.bstorm.tf_java2024_collegeapp.domain.enums.UserRole;
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

    public Student(String firstname, String lastname, String login, String email, String password, UserGender gender, boolean isActive, String contactPhoneNumber) {
        super(firstname, lastname, login, email, password, gender, isActive);
        this.contactPhoneNumber = contactPhoneNumber;
    }
}
