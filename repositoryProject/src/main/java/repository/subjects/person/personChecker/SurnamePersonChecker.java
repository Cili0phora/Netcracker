package repository.subjects.person.personChecker;


import repository.subjects.person.Person;
import repository.common.Checker;

public class SurnamePersonChecker implements Checker<Person> {
    @Override
    public boolean check(Person p1, Object value) {
        return p1.getSurname().equals(value.toString());
    }
}
