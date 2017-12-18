package repository.subjects.person.personExceptions;

/**
 * Exception throws if you try create person with empty surname
 */
public class EmptySurnameException extends Exception {

    @Override
    public String getMessage() {
        return "Surname cannot be empty";
    }
}
