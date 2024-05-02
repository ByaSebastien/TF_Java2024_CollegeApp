package be.bstorm.tf_java2024_collegeapp.bll.services.impls;

import be.bstorm.tf_java2024_collegeapp.bll.services.UserService;
import be.bstorm.tf_java2024_collegeapp.dal.repositories.UserRepository;
import be.bstorm.tf_java2024_collegeapp.domain.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow();
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Wrong password");
        }
        return user;
    }
}
