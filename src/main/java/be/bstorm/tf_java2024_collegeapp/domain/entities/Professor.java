package be.bstorm.tf_java2024_collegeapp.domain.entities;

import be.bstorm.tf_java2024_collegeapp.domain.enums.UserGender;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@AttributeOverride(name = "role", column = @Column(columnDefinition = "varchar(50) default 'PROFESSOR'"))
public class Professor extends User {

    @Getter @Setter
    @Column(name = "TITLE",nullable = false,length = 50)
    private String title;

    @Getter @Setter
    @Column(name = "IS_APPOINTED",nullable = false)
    private boolean isAppointed;

    public Professor(String firstname, String lastname, String login, String email, String password, UserGender gender, boolean isActive, String title, boolean isAppointed) {
        super(firstname, lastname, login, email, password, gender, isActive);
        this.title = title;
        this.isAppointed = isAppointed;
    }
}
