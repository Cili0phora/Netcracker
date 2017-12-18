package repository.subjects.person;

import repository.subjects.person.personExceptions.EmptySurnameException;
import repository.subjects.person.personExceptions.IlligalBirthDateException;

import org.joda.time.*;
import java.util.Comparator;
import java.util.UUID;
/**
 * Class, describing single person
 */
public class Person {
    /**
     * Person's surname
     */
    private String surname;
    /**
     * Person's birthday
     */
    private LocalDate birthday;
    /**
     * Person's unique identificator
     */
    private String id;

    /**
     * Override toString method
     * @return string representation of Person
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("surname: ").append(surname).append('\n');
        sb.append("birthday: ").append(birthday).append('\n');
        sb.append("age: ").append(getAge()).append('\n');
        sb.append("id: ").append(id).append('\n');
        return sb.toString();
    }

    /**
     * Class Person constructor, creating a new peron
     * with setting parameters. Generate unique ID.
     * @param surname person's surname
     * @param birthday persin's birthday
     */
    public Person(String surname, LocalDate birthday) {
        this.surname = surname;
        this.birthday = birthday;
        this.id = UUID.randomUUID().toString();
    }

    /**
     * Get person's surname
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set person's surname
     * @param surname New surname
     * @throws EmptySurnameException If new surname is empty throws exception
     */
    public void setSurname(String surname) throws EmptySurnameException {
        if (surname.isEmpty())
            throw new EmptySurnameException();
        this.surname = surname;
    }

    /**
     * Get person's birth date
     * @return Birth date
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Set birthday birth date
     * @param birthday New birth date
     * @throws IlligalBirthDateException
     */
    public void setBirthday(LocalDate birthday) throws IlligalBirthDateException {
        if (birthday.compareTo(LocalDate.now()) > 0) {
            throw new IlligalBirthDateException(birthday);
        }
        this.birthday = birthday;
    }

    /**
     * Get person's ID
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * Calculate person's age
     * @return age
     */
    public int getAge () {
        return Years.yearsBetween(birthday, new LocalDate()).getYears();
    }

    /**
     * Compare person with another person
     * @param p2 another person, what will be comere with this peron
     * @param pc personComparator, what shows what field will be uset to compare
     * @return result less than zero if this person less than p2, zero if persons are equal and positive number if this peron > p2
     */
    public int compareTo(Person p2, Comparator<Person> pc) {
        return pc.compare(this, p2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id != null ? id.equals(person.id) : person.id == null;
    }
}
