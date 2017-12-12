//package main.java;
import repository.Person;
import repository.PersonsRepository;

import org.joda.time.*;
import repository.comparator.SortByAge;
import repository.comparator.SortByBirthDate;
import repository.comparator.SortById;
import repository.comparator.SortBySurname;
import repository.sorts.InsertionSort;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        Person[] ar = {
//                new Person("mr. Orange", new LocalDate(1981,8,24)),
//                new Person("mr. White", new LocalDate(1981, 5, 1 )),
//                new Person("mr. Pink", new LocalDate(1985, 3, 18 )),
//                new Person("mr. Brown", new LocalDate(1980, 2, 1 )),
//                new Person("mr. Blonde", new LocalDate(1990, 11, 11 )),
//                new Person("mr. Blue", new LocalDate(1982, 5, 30 ))
//        };
//        for(int i = 0; i<ar.length; i++) {
//            System.out.println(ar[i].toString());
//        }
//        PersonsRepository result = new PersonsRepository(6);
//        result.add(new Person("mr. Blonde", new LocalDate(1990, 11, 11 )));
//        result.add(new Person("mr. Pink", new LocalDate(1985, 3, 18 )));
//        result.add(new Person("mr. Blue", new LocalDate(1982, 5, 30 )));
//        result.add(new Person("mr. Orange", new LocalDate(1981,8,24)));
//        result.add(new Person("mr. White", new LocalDate(1981, 5, 1 )));
//        result.add(new Person("mr. Brown", new LocalDate(1980, 2, 1 )));

        PersonsRepository ps = new PersonsRepository(5);
        ps.add(new Person("mr. Orange", new LocalDate(1981,8,24)));
        ps.add(new Person("mr. White", new LocalDate(1981, 5, 1 )));
        ps.add(new Person("mr. Pink", new LocalDate(1985, 3, 18 )));
        ps.add(new Person("mr. Brown", new LocalDate(1980, 2, 1 )));
        ps.add(new Person("mr. Blonde", new LocalDate(1990, 11, 11 )));
        ps.add(new Person("mr. Blue", new LocalDate(1982, 5, 30 )));

        ps.sort(new SortByBirthDate());

        System.out.println(ps.toString());


    }
}
