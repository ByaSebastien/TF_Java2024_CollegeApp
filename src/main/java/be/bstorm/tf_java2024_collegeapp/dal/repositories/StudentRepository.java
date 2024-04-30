package be.bstorm.tf_java2024_collegeapp.dal.repositories;

import be.bstorm.tf_java2024_collegeapp.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
