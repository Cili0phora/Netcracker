package repository.subjects.person.personExceptions;

import org.joda.time.*;

/**
 * Exception throws then you try create person, birth in future
 */
public class IlligalBirthDateException extends Exception {
    public LocalDate birthday;

    public IlligalBirthDateException(LocalDate birthday) {
        this.birthday= birthday;
    }

    @Override
    public String getMessage() {
        return "Birth date can not be later than today's: " + birthday.toString();
    }
}