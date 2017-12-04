package Repository.Sorts;

import Repository.Person;
import Repository.PersonsRepository;

import java.util.Comparator;

public class BubbleSort implements ISort{
    @Override
    public void sort(PersonsRepository rep, Comparator<Person> comp) {
        for (int i = 0; i<rep.getSize()-1;i++) {
            for (int j = 0; j<rep.getSize()-1;j++) {
                if(rep.getPersons()[j].compareTo(rep.getPersons()[j+1], comp) > 0) {
                    Person temp = rep.getPersons()[j];
                    rep.getPersons()[j] = rep.getPersons()[j+1];
                    rep.getPersons()[j+1] = temp;
                }
            }
        }
    }
}
