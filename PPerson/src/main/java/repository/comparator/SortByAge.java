package repository.comparator;

import repository.Person;

import java.util.Comparator;

public class SortByAge implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}
