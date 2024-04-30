package be.bstorm.tf_java2024_collegeapp.domain.entities;

import be.bstorm.tf_java2024_collegeapp.domain.enums.UserGender;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class User extends BaseEntity<Long>{

    @Getter @Setter
    @Column(name = "FIRST_NAME",nullable = false,length = 50)
    private String firstname;

    @Getter @Setter
    @Column(name = "LAST_NAME",nullable = false,length = 50)
    private String lastname;

    @Getter @Setter
    @Column(name = "LOGIN",nullable = false,length = 50)
    private String login;

    @Getter @Setter
    @Column(name = "EMAIL",nullable = false,length = 120,unique = true)
    private String email;

    @Getter @Setter
    @Column(name = "PASSWORD",nullable = false,length = 200)
    private String password;

    @Getter @Setter
    @Column(name = "GENDER",nullable = false)
    @Enumerated(EnumType.STRING)
    private UserGender gender;

    @Getter @Setter
    @Column(name = "IS_ACTIVE",nullable = false)
    private boolean isActive;

}
