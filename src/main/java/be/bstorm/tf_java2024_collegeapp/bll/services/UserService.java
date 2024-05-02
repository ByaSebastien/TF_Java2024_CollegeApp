package be.bstorm.tf_java2024_collegeapp.bll.services;

import be.bstorm.tf_java2024_collegeapp.domain.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User login(String email, String password);
}
