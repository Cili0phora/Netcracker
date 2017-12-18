package repository.common;

import java.util.Comparator;
import java.util.Iterator;

public interface Repository<T> extends Iterable<T> {
    boolean add(T value);
    T remove(int index);
    void sort(Comparator<T> comp);
    @Override
    Iterator<T> iterator();
}
