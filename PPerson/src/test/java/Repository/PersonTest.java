package Repository;

import Repository.RepositoryExceptions.EmptySurnameException;
import Repository.RepositoryExceptions.IlligalBirthDateException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    //arrange of test person
    private final Person PERSON_TEST = new Person("mr. Black", LocalDate.of(1997,11,11));

    @Test
    void setSurname() throws EmptySurnameException {
        //act
        PERSON_TEST.setSurname("mr. Gray");
        //assert
        assertEquals("mr. Gray", PERSON_TEST.getSurname());
    }
    @Test
    void setSurnameEmpty() {
        try {
            //act
            PERSON_TEST.setSurname("");
        }catch (Exception ex) {
            //assert
            assertEquals(ex.getMessage(), new EmptySurnameException().getMessage() );
        }
    }
    @Test
    void setBirthday() throws IlligalBirthDateException {
        //arrange
        LocalDate newBirthday =  LocalDate.of(1998,11,11);
        //act
        PERSON_TEST.setBirthday(newBirthday);
        //assert
        assertEquals(PERSON_TEST.getBirthday(), newBirthday);
    }
    @Test
    void setBirthdayIlligal() throws IlligalBirthDateException {
        //arrange
        LocalDate newBirthday =  LocalDate.now().plusYears(1);
        try {
            //act
            PERSON_TEST.setBirthday(newBirthday);
        }catch (Exception ex) {
            //assert
            assertEquals(ex.getMessage(), new IlligalBirthDateException(newBirthday).getMessage() );
        }
    }


    @Test
    void compareTo() {

    }

}