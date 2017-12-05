package Repository;

import Repository.Checker.AgePersonChecker;
import Repository.Checker.IPersonChecker;
import Repository.Sorts.ISort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Class, describing array of persons
 */
public class PersonsRepository {
    /**
     * Array of persons
     */
    private Person[] persons;
    /**
     * Actual size of array
     */
    private int size;
    /**
     * How many empty elements program adds in array if it full
     */
    private final int DLENGTH = 5;

    //private ISort sorter = Cobfigurator.getInstnce().getSorter();

    /**
     * Get actual size of array
     * @return Size of array
     */
    public int getSize() {
        return size;
    }

    /**
     * Constructor creates empty repository with setting size
     * @param size
     */
    public PersonsRepository(int size) {
        persons = new Person[size];
        this.size = 0;
    }

    /**
     * Contructor, creating repository for setting persons array
     * @param persons
     */
    public PersonsRepository(Person[] persons) {
        this.persons = persons;
        size = persons.length;
    }

    /**
     * Get array of Person
     * @return array of Person
     */
    public Person[] getPersons() {
        return persons;
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

    /**
     * Add person into array of Persons
     * @param aPerson new person
     * @return true, if adding successful
     */
    public boolean add(Person aPerson) {
        if (getIndex(aPerson.getId()) < 0) {
            if (size > persons.length - 1) {
                persons = Arrays.copyOf(persons, persons.length + DLENGTH);
            }
            persons[size] = aPerson;
            size++;
            return true;
        }
        return false;
    }

    /**
     * Get person's index in array
     * @param id person's ID
     * @return index or -1 if person not found
     */
    public int getIndex(String id) {
        for (int index = 0; index<size; index++) {
            if (persons[index].getId().equals(id))
                return index;
        }
        return -1;
    }

    /**
     * Remove person from array
     * @param id person's ID
     * @return deleted person or null, if person not found
     */
    public Person remove(String  id) {
        int i = getIndex(id);
        if (i >= 0) {
            Person result = persons[i];
            for (i++; i < size-1; i++) {
                persons[i] = persons[i + 1];
            }
            size--;
            return result;
        }
        return null;
    }

    /**
     * Sort array of Person's
     * @param comp comparator, what shows what field will be used to compare
     * @param srt sorting algorithm
     */
    public void sort(Comparator<Person> comp, ISort srt) {
        srt.sort(this,  comp);
    }

    private PersonsRepository search(IPersonChecker checker, Object value) {
        PersonsRepository result = new PersonsRepository(size);
        for (int i = 0; i<size; i++) {
            if (checker.check(persons[i], value))
                result.add(persons[i]);
        }
        return result;
    }

    /**
     * Find all person's with setting age
     * @param age
     * @return repository of result persons
     */
    public PersonsRepository searchBуAge(int age) {
        return search(new AgePersonChecker(),age);
    }
}