package Repository.Sorts;

import Repository.Comparator.IPersonComparator;
import Repository.Person;
import Repository.PersonsRepository;

public class InsertionSort implements ISort{

    @Override
    public void sort(PersonsRepository rep, IPersonComparator comp) {
        int j;
        Person temp;
        for (int i = 0; i<rep.getSize()-1; i++) {
            if (rep.getPersons()[i].compareTo(rep.getPersons()[i+1], comp) > 0) {
                temp = rep.getPersons()[i+1];
                rep.getPersons()[i+1] = rep.getPersons()[i];
                j = i;
                while (j > 0 && temp.compareTo(rep.getPersons()[j-1], comp) < 0) {
                    rep.getPersons()[j] = rep.getPersons()[j-1];
                    j--;
                }
                rep.getPersons()[j] = temp;
            }
        }
    }
}