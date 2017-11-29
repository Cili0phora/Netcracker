package Repository.Checker;

import Repository.Person;

import java.time.LocalDate;

public class BirthDatePersinChecker implements IPersonChecker {
    @Override
    public boolean check(Person p1, Object value) {
        return p1.getBirthday().equals((LocalDate)value);
    }
}
