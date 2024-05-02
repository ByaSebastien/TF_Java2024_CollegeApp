package be.bstorm.tf_java2024_collegeapp.domain.entities;

import be.bstorm.tf_java2024_collegeapp.domain.enums.UserGender;
import be.bstorm.tf_java2024_collegeapp.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class User extends BaseEntity<Long> implements UserDetails {

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

    @Getter @Setter
    @Column(name = "ROLE",nullable = true)
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.valueOf(this.getClass().getSimpleName().toUpperCase());

    public User(String firstname, String lastname, String login, String email, String password, UserGender gender, boolean isActive) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.isActive = isActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.toString()));
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
