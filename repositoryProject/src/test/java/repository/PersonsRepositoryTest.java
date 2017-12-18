package repository;

import com.sun.org.apache.regexp.internal.RE;
import repository.subjects.person.personComparator.SortByAge;
import repository.subjects.person.personComparator.SortByBirthDate;
import repository.subjects.person.personComparator.SortBySurname;
import org.junit.jupiter.api.Test;

import org.joda.time.*;
import repository.subjects.person.Person;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PersonsRepositoryTest {
    //arrange of test repository
    private final Person[] AR_TEST = {
            new Person("mr. Orange", new LocalDate(1981,8,24)),
            new Person("mr. White", new LocalDate(1981, 5, 1 )),
            new Person("mr. Pink", new LocalDate(1985, 3, 18 )),
            new Person("mr. Brown", new LocalDate(1980, 2, 1 )),
            new Person("mr. Blonde", new LocalDate(1990, 11, 11 )),
            new Person("mr. Blue", new LocalDate(1982, 5, 30 ))
    };
    private final  PersonsRepository REP_TEST = new PersonsRepository(AR_TEST);

    @Test
    void getIndex() {
        //act
        int index = REP_TEST.getIndex((Person)REP_TEST.getRep()[3]);

        //assert
        assertEquals(3, index);
    }

    @Test
    void add() {
        //arrange
        Person aPerson = new Person("mr. Black", new LocalDate(1997, 8,8));

        //act
        REP_TEST.add(aPerson);

        //assert
        assertEquals(aPerson, REP_TEST.getRep()[REP_TEST.getSize()-1]);
    }

    @Test
    void addToEmptyRepository() {
        PersonsRepository pr = new PersonsRepository(1);
        Person aPerson = new Person("mr. Black", new LocalDate(1997, 8,8));
        pr.add(aPerson);
        assertEquals(aPerson, pr.getRep()[0]);
    }
    @Test
    void remove() {
        //arrange
        Object[] aPersons = Arrays.copyOfRange(REP_TEST.getRep(),0,REP_TEST.getSize());

        //act
        REP_TEST.remove(0);

        //assert
        boolean OK = true;
        int i = 0;
        while (OK && i<REP_TEST.getSize()) {
            OK = REP_TEST.getRep()[i].equals(aPersons[i]);
            i++;
        }
        assertTrue(OK);
    }

    @Test
    void searchBуAge() {
        //arrange
        PersonsRepository expected = new PersonsRepository(2);
        expected.add((Person)REP_TEST.getRep()[0]);
        expected.add((Person)REP_TEST.getRep()[1]);

        //act
        PersonsRepository actual = REP_TEST.searchBуAge(36);

        //assert
        assertEquals(actual, expected);
    }

    @Test
    void sortByAge() {
        //arrange
        int[] res = {27, 32, 35, 36, 36, 37};
        //act
        REP_TEST.sort(new SortByAge());

        //assert
        boolean OK = true;
        int i = 0;
        while (OK && i<REP_TEST.getSize()) {
            OK = ((Person)REP_TEST.getRep()[i]).getAge() == (res[i]);
            i++;
        }
        assertTrue(OK);
    }

    @Test
    void sortBySurname() {
        //arrange
        String[] res = {
                "mr. Blonde",
                "mr. Blue",
                "mr. Brown",
                "mr. Orange",
                "mr. Pink",
                "mr. White"
        };
        //act
        REP_TEST.sort(new SortBySurname());

        //assert
        boolean OK = true;
        int i = 0;
        while (OK && i<REP_TEST.getSize()) {
            OK = ((Person)REP_TEST.getRep()[i]).getSurname().compareTo(res[i]) == 0;
            i++;
        }
        assertTrue(OK);
    }

    @Test
    void sortByBirthDate() {
        //arrange
        LocalDate[] res = {
                new LocalDate(1980, 2, 1 ),
                new LocalDate(1981, 5, 1 ),
                new LocalDate(1981,8,24),
                new LocalDate(1982, 5, 30 ),
                new LocalDate(1985, 3, 18 ),
                new LocalDate(1990, 11, 11 )
        };
        //act
        REP_TEST.sort(new SortByBirthDate());

        //assert
        boolean OK = true;
        int i = 0;
        while (OK && i<REP_TEST.getSize()) {
            OK = ((Person)REP_TEST.getRep()[i]).getBirthday().compareTo(res[i]) == 0;
            i++;
        }
        assertTrue(OK);
    }
}