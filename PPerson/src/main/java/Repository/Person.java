package Repository;

import Repository.Comparator.IPersonComparator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.UUID;

public class Person {
    private String surname;
    private LocalDate birthday;
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("surname: ").append(surname).append('\n');
        sb.append("birthday: ").append(birthday).append('\n');
        sb.append("id: ").append(id).append('\n');
        return sb.toString();
    }
    public static Person read() throws DateTimeParseException{
        Scanner in = new Scanner(System.in);
        Person aPerson = new Person();
        System.out.print("surname: ");
        aPerson.setSurname(in.nextLine());
        System.out.print("birthday: ");
        aPerson.setBirthday(LocalDate.parse(in.nextLine()));
        return aPerson;
    }

    public Person(String surname, LocalDate birthday) {
        this.surname = surname;
        this.birthday = birthday;
        this.id = UUID.randomUUID().toString();
    }
    public Person() {
        this.surname = "";
        this.birthday = LocalDate.now();
        this.id = UUID.randomUUID().toString();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public int getAge () {
        return Period.between(birthday,  LocalDate.now()).getYears();
    }

    public int compareTo(Person p2, IPersonComparator pc) {
        return pc.compare(this, p2);
    }
}
