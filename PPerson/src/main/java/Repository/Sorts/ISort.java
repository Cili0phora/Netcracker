package Repository.Sorts;

import Repository.Person;
import Repository.PersonsRepository;

import java.util.Comparator;

public interface ISort {
    void sort(PersonsRepository rep, Comparator<Person> comp);
}
