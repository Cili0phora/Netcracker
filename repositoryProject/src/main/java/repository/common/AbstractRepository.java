package repository.common;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import repository.common.sorts.InsertionSort;
import repository.subjects.person.Person;

public abstract class AbstractRepository<T> implements Repository<T> {
    protected Object[] rep;
    protected int size;
    private final int DLENGTH = 5;
    //private ISort sorter = new InsertionSort();
    private ISort sorter = Configurator.getInstance().getSorter();

    public Object[] getRep() {
        return rep;
    }

    public void setRep(Object[] rep) {
        this.rep = rep;
    }

    public int getSize() {
        return size;
    }
    protected abstract AbstractRepository<T> search(Checker<T> checker, Object value);

    @Override
    public boolean add(T value) {
        if (getIndex(value) == -1) {
            if (size > rep.length - 1) {
                rep = Arrays.copyOf(rep, rep.length + DLENGTH);
            }
            size++;
            rep[size-1] = value;
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index == -1) {
            T result = (T)rep[index];
            for (index++; index < size-1; index++) {
                rep[index] = rep[index + 1];
            }
            size--;
            return result;
        }
        return null;
    }

    @Override
    public void sort(Comparator<T> comp) {
        sorter.sort(this,  comp);
    }

    public int getIndex(T value) {
        if (size!= 0) {
            for (int index = 0; index < size; index++) {
                Object tmp = (T) rep[index];
                if (tmp.equals(value))
                    return index;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<getSize(); i++) {
            sb.append(getRep()[i].toString()).append("\n");
        }
        sb.append("size: ").append(getSize());
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    class ArrayIterator implements Iterator<T> {
        int current = 0;

        public boolean hasNext() {
            if (current < size) {
                return true;
            } else {
                return false;
            }
        }


        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T)rep[current++];
        }
    }
}
