package Repository.Sorts;

import Repository.Person;
import Repository.PersonsRepository;

import java.util.Comparator;

/**
 * Interface for sorts
 */
public interface ISort {
    /**
     * Sort algorythm
     * @param rep repository, that will be sorted
     * @param comp comparator, what shows what field will be uset to compare
     */
    void sort(PersonsRepository rep, Comparator<Person> comp);
}
