package repository.checker;


import repository.Person;

public class SurnamePersonChecker implements Checker<Person> {
    @Override
    public boolean check(Person p1, Object value) {
        return p1.getSurname().equals(value.toString());
    }
}
