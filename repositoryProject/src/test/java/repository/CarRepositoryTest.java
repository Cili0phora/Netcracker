package repository;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;
import repository.subjects.car.Car;
import repository.subjects.car.carComparator.SortByBrand;
import repository.subjects.car.carComparator.SortBySerialNumber;
import repository.subjects.person.Person;
import repository.subjects.person.personComparator.SortBySurname;

import javax.smartcardio.CardPermission;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {
    //arrange of test repository
    private final Car[] AR_TEST = {
            new Car("BMV", "E102CH102"),
            new Car("Ford", "A200CH36"),
            new Car("Hyundai", "B360GH36"),
            new Car("Audi", "C123CH188"),
            new Car("BMV", "E231KT102"),
            new Car("Honda", "M200CH102")
    };
    private final  CarRepository REP_TEST = new CarRepository(AR_TEST);
    @Test
    void searchByBrand() {
        //arrange
        CarRepository expected = new CarRepository(6);
        expected.add(REP_TEST.get(0));
        expected.add(REP_TEST.get(4));

        //act
        CarRepository actual = REP_TEST.searchByBrand("BMV");

        //assert
        assertArrayEquals(actual.getRep(), expected.getRep());
    }

    @Test
    void searchBySerialNumber() {
        //arrange
        CarRepository expected = new CarRepository(6);
        expected.add(REP_TEST.get(0));

        //act
        CarRepository actual = REP_TEST.searchBySerialNumber("E102CH102");

        //assert
        assertArrayEquals(expected.getRep(), actual.getRep());
    }

    @Test
    void add() {
        //arrange
        Car aCar = new Car("Honda", "B360GH88");

        //act
        REP_TEST.add(aCar);

        //assert
        assertEquals(aCar, REP_TEST.getRep()[REP_TEST.getSize()-1]);

    }
    @Test
    void addToEmptyRepository() {
        //arrange
        CarRepository pr = new CarRepository(1);
        Car aPerson = new Car("Honda", "B360GH88");

        //act
        pr.add(aPerson);

        //assert
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
    void sortByBrand() {
        //arrange
        String[] res = {
                "Audi",
                "BMV",
                "BMV",
                "Ford",
                "Honda",
                "Hyundai"
        };
        //act
        REP_TEST.sort(new SortByBrand());

        //assert
        boolean OK = true;
        int i = 0;
        while (OK && i<REP_TEST.getSize()) {
            OK = (REP_TEST.get(i).getBrand().compareTo(res[i]) == 0);
            i++;
        }
        assertTrue(OK);
    }
    @Test
    void sortBySerialNumber() {
        //arrange
        String[] res = {
                "A200CH36",
                "B360GH36",
                "C123CH188",
                "E102CH102",
                "E231KT102",
                "M200CH102"
        };
        //act
        REP_TEST.sort(new SortBySerialNumber());

        //assert
        boolean OK = true;
        int i = 0;
        while (OK && i<REP_TEST.getSize()) {
            OK = REP_TEST.get(i).getSerialNumber().compareTo(res[i]) == 0;
            i++;
        }
        assertTrue(OK);
    }

}