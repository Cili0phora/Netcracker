//package main.java;
import Repository.Comparator.SortByAge;
import Repository.Comparator.SortByBirthDate;
import Repository.Person;
import Repository.PersonsRepository;
import Repository.Sorts.InsertionSort;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person[] ar = {
                new Person("mr. Orange", LocalDate.of(1981,8,24)),
                new Person("mr. White", LocalDate.of(1981, 5, 1 )),
                new Person("mr. Pink", LocalDate.of(1985, 3, 18 )),
                new Person("mr. Brown", LocalDate.of(1980, 2, 1 )),
                new Person("mr. Blonde", LocalDate.of(1990, 11, 11 )),
                new Person("mr. Blue", LocalDate.of(1982, 5, 30 ))
        };
        for(int i = 0; i<ar.length; i++) {
            System.out.println(ar[i].toString());
        }
        PersonsRepository rep_test = new PersonsRepository(ar);

//        PersonsRepository ps = new PersonsRepository(5);
//        ps.add(new Person("mr. Orange", LocalDate.of(1981,8,24)));
//        ps.add(new Person("mr. White", LocalDate.of(1981, 5, 1 )));
//        ps.add(new Person("mr. Pink", LocalDate.of(1985, 3, 18 )));
//        ps.add(new Person("mr. Brown", LocalDate.of(1980, 2, 1 )));
//        ps.add(new Person("mr. Blonde", LocalDate.of(1990, 11, 11 )));
//        ps.add(new Person("mr. Blue", LocalDate.of(1982, 5, 30 )));
//
//        ps.sort(new SortByAge(),new InsertionSort());
//
//        System.out.println(ps.toString());


    }
}
