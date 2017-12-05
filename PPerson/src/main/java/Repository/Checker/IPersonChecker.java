package Repository.Checker;

import Repository.Person;

/**
 * interface to check equality between person and object
 */
public interface IPersonChecker {
    /**
     *
     * @param p1
     * @param value
     * @return
     */
    boolean check (Person p1, Object value);
}
