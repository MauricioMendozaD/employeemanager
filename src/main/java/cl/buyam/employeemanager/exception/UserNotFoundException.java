package cl.buyam.employeemanager.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String s) {
        super(s);
    }
}
