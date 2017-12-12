package repository;

import repository.checker.Checker;

import java.util.Comparator;

public interface Repository<T> {
    boolean add(T value);
    T remove(String id);
    void sort(Comparator<T> comp);
    T search(Checker<T>);
}
