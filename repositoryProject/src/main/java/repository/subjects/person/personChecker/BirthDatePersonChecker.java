package repository.subjects.person.personChecker;

import repository.subjects.person.Person;
import repository.common.Checker;

import java.time.LocalDate;

public class BirthDatePersonChecker implements Checker<Person> {
    @Override
    public boolean check(Person p1, Object value) {
        return p1.getBirthday().equals((LocalDate)value);
    }
}
