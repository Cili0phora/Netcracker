package Repository;

import Repository.Comparator.IPersonComparator;
import Repository.Sorts.ISort;

import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

public class PersonsRepository {
    private Person[] persons;
    private int size;
    //private ISort sorter = Cobfigurator.getInstnce().getSorter();

    public int getSize() {
        return size;
    }

    public PersonsRepository() {
        persons = new Person[0];
        size = 0;
    }
    PersonsRepository(Person[] persons) {
        this.persons = persons;
        size = persons.length-1;
    }

    public Person[] getPersons() {
        return persons;
    }

    public void setPersons(Person[] persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person p : persons) {
            sb.append(p.toString()).append("\n");
        }
        sb.append("size: ").append(size);
        return sb.toString();
    }

    public void read() throws DateTimeParseException{
        Scanner in = new Scanner(System.in);
        add(Person.read());
        char c;
        do {
            System.out.println("One more? (y/n)");
            c = in.next().charAt(0);
            add(Person.read());
        } while (c == 'y');
    }

    public boolean add(Person aPerson) {
        if (getIndex(aPerson.getId()) <= 0) {
            persons = Arrays.copyOf(persons, persons.length + 1);
            persons[persons.length - 1] = aPerson;
            size++;
            return true;
        }
        return false;
    }

    public int getIndex(String id) {
        for (int index = 0; index<size; index++) {
            if (persons[index].getId().equals(id))
                return index;
        }
        return -1;
    }

    public Person remove(String  id) {
        int i = getIndex(id);
        if (i >= 0) {
            Person result = persons[i];
            for (i++; i <= size - 1; i++) {
                persons[i + 1] = persons[i];
            }
            persons = Arrays.copyOf(persons, persons.length - 1);
            size--;
            return result;
        }
        return null;
    }

    public void sort(IPersonComparator comp, ISort srt) {
        srt.sort(this, comp);
    }
}
