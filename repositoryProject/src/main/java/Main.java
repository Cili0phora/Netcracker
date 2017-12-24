//package main.java;
import repository.CarRepository;
import repository.subjects.car.Car;
import repository.subjects.car.carComparator.SortByBrand;
import repository.subjects.car.carComparator.SortBySerialNumber;
import repository.subjects.person.Person;
import repository.PersonsRepository;

import org.joda.time.*;
import repository.subjects.person.personComparator.SortByBirthDate;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
    //arrange of test repository
        Car[] ar= {
            new Car("BMV", "E102CH102"),
            new Car("Ford", "A200CH36"),
            new Car("Hyundai", "B360GH36"),
            new Car("Audi", "C123CH188"),
            new Car("BMV", "E231KT102"),
            new Car("Honda", "M200CH102")
        };

        CarRepository rep = new CarRepository(ar);
        rep.sort(new SortBySerialNumber());
        System.out.println(rep.toString());

    }
}
