package repository.common;

import repository.common.repositoryes.AbstractRepository;

import java.util.Comparator;

/**
 * Interface for sorts
 */
public interface ISort {
    /**
     * Sort algorythm
     * @param rep repository, that will be sorted
     * @param comp personComparator, what shows what field will be uset to compare
     */
    void sort(AbstractRepository rep, Comparator comp);
}
