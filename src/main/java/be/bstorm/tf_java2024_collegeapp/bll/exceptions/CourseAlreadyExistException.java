package be.bstorm.tf_java2024_collegeapp.bll.exceptions;

public class CourseAlreadyExistException extends CourseException{

    public CourseAlreadyExistException() {
        super("Course already exist");
    }

    public CourseAlreadyExistException(String message) {
        super(message);
    }
}
