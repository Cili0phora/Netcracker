package Repository.Comparator;

import Repository.Person;

public class SortByAge implements IPersonComparator {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getBirthday().compareTo(p2.getBirthday());
    }
}
