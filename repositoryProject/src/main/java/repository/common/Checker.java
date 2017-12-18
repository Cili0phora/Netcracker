package repository.common;

/**
 * interface to check equality between person and object
 */
public interface Checker<T> {
    /**
     *
     * @param p1
     * @param value
     * @return
     */
    boolean check (T p1, Object value);
}
