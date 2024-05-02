package be.bstorm.tf_java2024_collegeapp.api;

import be.bstorm.tf_java2024_collegeapp.domain.entities.User;
import be.bstorm.tf_java2024_collegeapp.domain.enums.UserRole;
import lombok.Data;

@Data
public class UserTokenDTO {

    private Long id;
    private String login;
    private UserRole userRole;
    private String token;

    public UserTokenDTO(Long id, String login, UserRole userRole) {
        this.id = id;
        this.login = login;
        this.userRole = userRole;
    }

    public static UserTokenDTO fromEntity(User u) {

        return new UserTokenDTO(u.getId(), u.getLogin(), u.getRole());
    }
}
