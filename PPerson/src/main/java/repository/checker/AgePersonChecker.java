package repository.checker;

import repository.Person;

public class AgePersonChecker implements Checker<Person> {
    @Override
    public boolean check(Person p1, Object value) {
        return p1.getAge() == (int)value;
    }
}
