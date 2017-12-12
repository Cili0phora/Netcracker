package repository;

import repository.comparator.SortByAge;
import repository.comparator.SortByBirthDate;
import repository.comparator.SortBySurname;
import repository.sorts.InsertionSort;
import org.junit.jupiter.api.Test;

import org.joda.time.*;
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
        int index = REP_TEST.getIndex(REP_TEST.getPersons()[3].getId());

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
        assertEquals(aPerson, REP_TEST.getPersons()[REP_TEST.getSize()-1]);
    }
    @Test
    void remove() {
        //arrange
        Person[] aPersons = Arrays.copyOfRange(REP_TEST.getPersons(),0,REP_TEST.getSize());

        //act
        REP_TEST.remove(REP_TEST.getPersons()[0].getId());

        //assert
        boolean OK = true;
        int i = 0;
        while (OK && i<REP_TEST.getSize()) {
            OK = REP_TEST.getPersons()[i] == aPersons[i];
            i++;
        }
        assertTrue(OK);
    }

    @Test
    void searchBуAge() {
    }

    @Test
    void sortByAge() {
        //arrange
        LocalDate[] res = {
                new LocalDate(1990, 11, 11 ),
                new LocalDate(1985, 3, 18 ),
                new LocalDate(1982, 5, 30 ),
                new LocalDate(1981,8,24),
                new LocalDate(1981, 5, 1 ),
                new LocalDate(1980, 2, 1 )
        };
        //act
        REP_TEST.sort(new SortByAge());

        //assert
        boolean OK = true;
        int i = 0;
        while (OK && i<REP_TEST.getSize()) {
            OK = REP_TEST.getPersons()[i].getBirthday().compareTo(res[i]) == 0;
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
            OK = REP_TEST.getPersons()[i].getSurname().compareTo(res[i]) == 0;
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
            OK = REP_TEST.getPersons()[i].getBirthday().compareTo(res[i]) == 0;
            i++;
        }
        assertTrue(OK);
    }
}