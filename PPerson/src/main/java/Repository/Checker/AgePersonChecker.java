package Repository.Checker;

import Repository.Person;

public class AgePersonChecker implements IPersonChecker {
    @Override
    public boolean check(Person p1, Object value) {
        return p1.getAge() == (int)value;
    }
}
