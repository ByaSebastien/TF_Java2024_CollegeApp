package be.bstorm.tf_java2024_collegeapp.dal.repositories;

import be.bstorm.tf_java2024_collegeapp.domain.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
}
