package Repository.Sorts;

import Repository.Comparator.IPersonComparator;
import Repository.PersonsRepository;

public interface ISort {
    void sort(PersonsRepository rep, IPersonComparator comp);
}
