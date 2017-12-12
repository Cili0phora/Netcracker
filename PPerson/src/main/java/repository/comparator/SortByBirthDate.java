package repository.comparator;

import repository.Person;

import java.util.Comparator;

public class SortByBirthDate implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getBirthday().compareTo(p2.getBirthday());
    }
}
