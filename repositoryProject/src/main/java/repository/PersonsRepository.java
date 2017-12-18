package repository;

import repository.subjects.person.personChecker.AgePersonChecker;
import repository.subjects.person.personChecker.BirthDatePersonChecker;
import repository.common.AbstractRepository;
import repository.common.Checker;
import repository.subjects.person.Person;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Class, describing array of persons
 */
public class PersonsRepository extends AbstractRepository<Person>{

    public PersonsRepository(int size) {
        this.rep = new Person[size];
        this.size = 0;
    }

    /**
     * Contructor, creating repository for setting persons array
     * @param persons
     */
    public PersonsRepository(Person[] persons) {
        this.rep = persons;
        this.size = persons.length;
    }
    @Override
    protected AbstractRepository<Person> search(Checker<Person> checker, Object value) {
        PersonsRepository result = new PersonsRepository(getSize());
        for (int i = 0; i<getSize(); i++) {
            if (checker.check((Person)getRep()[i], value))
                result.add((Person)getRep()[i]);
        }
        return result;
    }

    /**
     * Find all person's with setting age
     * @param age
     * @return repository of result persons
     */
    public PersonsRepository searchBуAge(int age) {
        return (PersonsRepository)search(new AgePersonChecker(),age);
    }

    public PersonsRepository searchBуBirthDate(int age) {
        return (PersonsRepository)search(new BirthDatePersonChecker(),age);
    }

    public PersonsRepository searchBуSurname(int age) {
        return (PersonsRepository)search(new AgePersonChecker(),age);
    }
}