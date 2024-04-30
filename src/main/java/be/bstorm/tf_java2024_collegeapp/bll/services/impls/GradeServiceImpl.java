package be.bstorm.tf_java2024_collegeapp.bll.services.impls;

import be.bstorm.tf_java2024_collegeapp.bll.services.GradeService;
import be.bstorm.tf_java2024_collegeapp.dal.repositories.GradeRepository;
import be.bstorm.tf_java2024_collegeapp.domain.entities.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    @Override
    public void add(Grade g) {
        gradeRepository.save(g);
    }
}
