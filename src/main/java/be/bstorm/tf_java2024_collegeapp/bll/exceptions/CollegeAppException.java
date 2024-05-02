package be.bstorm.tf_java2024_collegeapp.bll.exceptions;

public class CollegeAppException extends RuntimeException{

    private int status;
    private Object message;

    public CollegeAppException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        StackTraceElement element = this.getStackTrace()[0];
        return this.getClass().getSimpleName() + " throw in : " + element.getFileName() + " in method " + element.getMethodName() + " at line number " + element.getLineNumber() + " with message " + this.getMessage() ;
    }
}
