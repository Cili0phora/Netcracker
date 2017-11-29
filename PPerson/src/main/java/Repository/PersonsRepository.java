package Repository;

import Repository.Checker.AgePersonChecker;
import Repository.Checker.IPersonChecker;
import Repository.Comparator.IPersonComparator;
import Repository.Sorts.ISort;

import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

public class PersonsRepository {
    private Person[] persons;
    private int size;
    private final int dLangth = 5;
    //private ISort sorter = Cobfigurator.getInstnce().getSorter();

    public int getSize() {
        return size;
    }

    public PersonsRepository(int size) {
        persons = new Person[size];
        this.size = 0;
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
        for (int i = 0; i<size; i++) {
            sb.append(persons[i].toString()).append("\n");
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
        if (getIndex(aPerson.getId()) < 0) {
            if (size > persons.length - 1) {
                persons = Arrays.copyOf(persons, persons.length + dLangth);
            }
            persons[size] = aPerson;
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
            size--;
            return result;
        }
        return null;
    }

    public void sort(IPersonComparator comp, ISort srt) {
        srt.sort(this, comp);
    }

    private PersonsRepository search(IPersonChecker checker, Object value) {
        PersonsRepository result = new PersonsRepository(size);
        for (int i = 0; i<size; i++) {
            if (checker.check(persons[i], value))
                result.add(persons[i]);
        }
        return result;
    }

    public PersonsRepository searchBуAge(int age) {
        return search(new AgePersonChecker(),age);
    }
}