package Repository;

import Repository.Comparator.SortByAge;
import Repository.Sorts.InsertionSort;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PersonsRepositoryTest {
    //arrange of test repository
    private final Person[] AR_TEST = {
            new Person("mr. Orange", LocalDate.of(1981,8,24)),
            new Person("mr. White", LocalDate.of(1981, 5, 1 )),
            new Person("mr. Pink", LocalDate.of(1985, 3, 18 )),
            new Person("mr. Brown", LocalDate.of(1980, 2, 1 )),
            new Person("mr. Blonde", LocalDate.of(1990, 11, 11 )),
            new Person("mr. Blue", LocalDate.of(1982, 5, 30 ))
    };
    private final PersonsRepository REP_TEST = new PersonsRepository(AR_TEST);

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
        Person aPerson = new Person("mr. Black", LocalDate.of(1997, 8,8));

        //act
        REP_TEST.add(aPerson);

        //assert
        assertEquals(aPerson, REP_TEST.getPersons()[REP_TEST.getSize()-1]);
    }
    @Test
    void remove() {
        REP_TEST.remove(REP_TEST.getPersons()[0].getId());
        Person[] aPersons = Arrays.copyOfRange(REP_TEST.getPersons(),0,REP_TEST.getSize());
        PersonsRepository pr = new PersonsRepository(aPersons);
        assertEquals(REP_TEST, pr);
    }

    @Test
    void searchBуAge() {
    }

    @Test
    void sort() {
        //arrange
        PersonsRepository result = new PersonsRepository(6);
        result.add(new Person("mr. Blonde", LocalDate.of(1990, 11, 11 )));
        result.add(new Person("mr. Pink", LocalDate.of(1985, 3, 18 )));
        result.add(new Person("mr. Blue", LocalDate.of(1982, 5, 30 )));
        result.add(new Person("mr. Orange", LocalDate.of(1981,8,24)));
        result.add(new Person("mr. White", LocalDate.of(1981, 5, 1 )));
        result.add(new Person("mr. Brown", LocalDate.of(1980, 2, 1 )));

        //act
        REP_TEST.sort(new SortByAge(), new InsertionSort());

        //assert
        boolean OK = true;
        int i = 0;
        while (OK && i<REP_TEST.getSize()) {
            OK = REP_TEST.getPersons()[i].compareTo(result.getPersons()[i], new SortByAge()) == 0;
            i++;
        }
        assertTrue(OK);

    }

}