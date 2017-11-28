//package main.java;
import Repository.Comparator.SortByAge;
import Repository.Comparator.SortById;
import Repository.Comparator.SortBySurname;
import Repository.Person;
import Repository.PersonsRepository;
import Repository.Sorts.BubbleSort;
import Repository.Sorts.InsertionSort;
import sun.dc.path.PathError;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        PersonsRepository ps = new PersonsRepository();
        ps.add(new Person("mr. Orange", LocalDate.of(1881,8,24)));
        ps.add(new Person("mr. White", LocalDate.of(1881, 5, 1 )));
        ps.add(new Person("mr. Pink", LocalDate.of(1885, 3, 18 )));
        ps.add(new Person("mr. Brown", LocalDate.of(1880, 2, 1 )));
        ps.add(new Person("mr. Blonde", LocalDate.of(1890, 11, 11 )));
        ps.add(new Person("mr. Blue", LocalDate.of(1882, 5, 30 )));

        ps.sort(new SortByAge(),new InsertionSort());

        System.out.println(ps.toString());


    }
}
