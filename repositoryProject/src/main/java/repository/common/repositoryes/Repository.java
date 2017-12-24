package repository.common.repositoryes;

import repository.common.Checker;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Repository interface
 * @param <T> type of repository item
 */
public interface Repository<T> extends Iterable<T> {
    /**
     * Add value into repository
     * @param value value to add
     * @return
     */
    boolean add(T value);

    /**
     * Remove value from repository
     * @param index index of removing value
     * @return
     */
    T remove(int index);

    /**
     * Sorting repository
     * @param comp compare logic
     */
    void sort(Comparator<T> comp);
    Repository<T> search(Checker<T> checker, Object value);
    T get(int index);
    @Override
    Iterator<T> iterator();
}
