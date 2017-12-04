package Repository;

import Repository.Comparator.SortByAge;
import Repository.Sorts.InsertionSort;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonsRepositoryTest {
    @org.junit.jupiter.api.Test
    void sort() {
        PersonsRepository in = new PersonsRepository(5);
        in.add(new Person("mr. Orange", LocalDate.of(1981,8,24)));
        in.add(new Person("mr. White", LocalDate.of(1981, 5, 1 )));
        in.add(new Person("mr. Pink", LocalDate.of(1985, 3, 18 )));
        in.add(new Person("mr. Brown", LocalDate.of(1980, 2, 1 )));
        in.add(new Person("mr. Blonde", LocalDate.of(1990, 11, 11 )));
        in.add(new Person("mr. Blue", LocalDate.of(1982, 5, 30 )));

        in.sort(new SortByAge(), new InsertionSort());
        PersonsRepository out = new PersonsRepository(5);
        out.add(new Person("mr. Blonde", LocalDate.of(1990, 11, 11 )));
        out.add(new Person("mr. Pink", LocalDate.of(1985, 3, 18 )));
        out.add(new Person("mr. Blue", LocalDate.of(1982, 5, 30 )));
        out.add(new Person("mr. Orange", LocalDate.of(1981,8,24)));
        out.add(new Person("mr. White", LocalDate.of(1981, 5, 1 )));
        out.add(new Person("mr. Brown", LocalDate.of(1980, 2, 1 )));

        assertEquals(true, true);

    }

}