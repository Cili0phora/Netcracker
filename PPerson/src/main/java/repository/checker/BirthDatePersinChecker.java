package repository.checker;

import repository.Person;

import java.time.LocalDate;

public class BirthDatePersinChecker implements Checker<Person> {
    @Override
    public boolean check(Person p1, Object value) {
        return p1.getBirthday().equals((LocalDate)value);
    }
}
