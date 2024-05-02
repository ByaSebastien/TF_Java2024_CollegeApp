package be.bstorm.tf_java2024_collegeapp.il.utils;

import be.bstorm.tf_java2024_collegeapp.dal.repositories.ProfessorRepository;
import be.bstorm.tf_java2024_collegeapp.dal.repositories.StudentRepository;
import be.bstorm.tf_java2024_collegeapp.dal.repositories.UserRepository;
import be.bstorm.tf_java2024_collegeapp.domain.entities.Professor;
import be.bstorm.tf_java2024_collegeapp.domain.entities.Student;
import be.bstorm.tf_java2024_collegeapp.domain.entities.User;
import be.bstorm.tf_java2024_collegeapp.domain.enums.UserGender;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if(studentRepository.count() == 0) {
            Student student = new Student(
                    "Rocky",
                    "Balboa",
                    "Rocky",
                    "rock@test.be",
                    passwordEncoder.encode("Test1234="),
                    UserGender.MALE,
                    true,
                    "0000");
            studentRepository.save(student);
        }
        if(professorRepository.count() == 0) {
            Professor professor = new Professor(
                    "Georges",
                    "Clooney",
                    "Le clown",
                    "georgy@test.be",
                    passwordEncoder.encode("Test1234="),
                    UserGender.MALE,
                    true,
                    "The GOAT",
                    true
            );
            professorRepository.save(professor);
        }

        List<User> users = userRepository.findAll();
    }
}
