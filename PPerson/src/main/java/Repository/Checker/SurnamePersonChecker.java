package Repository.Checker;


import Repository.Person;

public class SurnamePersonChecker implements IPersonChecker {
    @Override
    public boolean check(Person p1, Object value) {
        return p1.getSurname().equals(value.toString());
    }
}
