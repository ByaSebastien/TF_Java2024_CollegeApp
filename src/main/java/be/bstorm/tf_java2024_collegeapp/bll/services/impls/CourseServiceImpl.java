package be.bstorm.tf_java2024_collegeapp.bll.services.impls;

import be.bstorm.tf_java2024_collegeapp.bll.exceptions.CourseAlreadyExistException;
import be.bstorm.tf_java2024_collegeapp.bll.services.CourseService;
import be.bstorm.tf_java2024_collegeapp.dal.repositories.CourseRepository;
import be.bstorm.tf_java2024_collegeapp.domain.entities.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
//    @RequiredArgsConstructor cree un constructor recevant en param tout les champs private final
//    public CourseServiceImpl(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    }

    @Override
    public Long add(Course c) {
        if(courseRepository.existsByName(c.getName())){
            throw new CourseAlreadyExistException("Course with name " + c.getName() + " already exist.");
        }
        return courseRepository.save(c).getId();
    }
}
