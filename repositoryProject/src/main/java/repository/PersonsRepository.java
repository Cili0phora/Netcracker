package repository;

import repository.common.repositoryes.Repository;
import repository.subjects.person.personChecker.AgePersonChecker;
import repository.subjects.person.personChecker.BirthDatePersonChecker;
import repository.common.repositoryes.AbstractRepository;
import repository.common.Checker;
import repository.subjects.person.Person;
import repository.subjects.person.personChecker.SurnamePersonChecker;

import org.joda.time.*;

/**
 * Class, describing array of persons
 */
public class PersonsRepository extends AbstractRepository<Person>{
    /**
     * Constructor, creating empty repository with setting size
     * @param size setting size
     */
    public PersonsRepository(int size) {
        this.rep = new Person[size];
        this.size = 0;
    }

    /**
     * Contructor, creating repository for setting persons array
     * @param persons setting repository
     */
    public PersonsRepository(Person[] persons) {
        this.rep = persons;
        this.size = persons.length;
    }

    /**
     * Find all person's with setting age
     * @param age setting age
     * @return repository of result persons
     */
    public PersonsRepository searchBуAge(int age) {
        return (PersonsRepository)search(new AgePersonChecker(),age);
    }

    /**
     * Find all person's with setting birthdate
     * @param birthdate
     * @return repository of result persons
     */
    public PersonsRepository searchBуBirthDate(LocalDate birthdate) {
        return (PersonsRepository)search(new BirthDatePersonChecker(), birthdate);
    }

    /**
     * Find all person's with setting surname
     * @param surname
     * @return repository of result persons
     */
    public PersonsRepository searchBуSurname(String surname) {
        return (PersonsRepository)search(new SurnamePersonChecker(), surname);
    }

    public Repository<Person> getRepositoryInstance(int size) {
        return new PersonsRepository(size);
    }


}