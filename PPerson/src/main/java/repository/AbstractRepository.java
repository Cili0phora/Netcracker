package repository;

import java.util.Arrays;
import java.util.Comparator;

public abstract class AbstractRepository<T> implements Repository<T> {
    private Object[] rep;
    private int size;
    private final int DLENGTH = 5;

    @Override
    public boolean add(T value) {
        if (getIndex(value) == 0) {
            if (size > rep.length - 1) {
                rep = Arrays.copyOf(rep, rep.length + DLENGTH);
            }
            rep[size] = rep;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public T search() {
        return null;
    }

    @Override
    public T remove(T value) {
        int i = getIndex(value);
        if (i == -1) {
            T result = (T)rep[i];
            for (i++; i < size-1; i++) {
                rep[i] = rep[i + 1];
            }
            size--;
            return result;
        }
        return null;
    }

    @Override
    public void sort(Comparator<T> comp) {

    }
    private int getIndex(String id) {
        for (int index = 0; index<size; index++) {
            T tmp = (T)rep[index];
            if (tmp.getId().equals(id))
                return index;
        }
        return -1;
    }
}
