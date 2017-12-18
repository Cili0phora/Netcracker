package repository.subjects.person.personComparator;

import repository.subjects.person.Person;

import java.util.Comparator;

public class SortBySurname implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getSurname().compareTo(p2.getSurname());
    }
}
