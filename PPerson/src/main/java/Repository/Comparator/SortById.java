package Repository.Comparator;

import Repository.Person;

public class SortById implements IPersonComparator {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getId().compareTo(p2.getId());
    }
}
