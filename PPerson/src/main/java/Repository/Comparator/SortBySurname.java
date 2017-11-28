package Repository.Comparator;

import Repository.Person;

public class SortBySurname implements IPersonComparator {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getSurname().compareTo(p2.getSurname());
    }
}
