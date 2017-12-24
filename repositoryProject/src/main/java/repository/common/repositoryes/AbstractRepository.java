package repository.common.repositoryes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import repository.common.Checker;
import repository.common.Configurator;
import repository.common.ISort;

/**
 * Realisation of general repository logic
 * @param <T> type of repository item
 */
public abstract class AbstractRepository<T> implements Repository<T> {
    /**
     * Array for cars storage
     */
    protected Object[] rep;
    /**
     * Actual size of repository
     */
    protected int size;
    /**
     * Full repository extention
     */
    protected final int DLENGTH = 5;
    //private ISort sorter = new InsertionSort();
    private ISort sorter = Configurator.getInstance().getSorter();

    /**
     * Getter for array of values
     * @return array of values
     */
    public Object[] getRep() {
        return rep;
    }

    /**
     * Setter for array of values
     * @param rep new array of values
     */
    public void setRep(Object[] rep) {
        this.rep = rep;
    }

    /**
     * Getter for repository size
     * @return repository size
     */
    public int getSize() {
        return size;
    }

    /**
     * Search
     * @param checker
     * @param value
     * @return
     */
    @Override
    public Repository<T> search(Checker<T> checker, Object value) {
        Repository result = getRepositoryInstance(size);
        for (int i = 0; i<getSize(); i++) {
            if (checker.check(get(i), value))
                result.add(get(i));
        }
        return result;
    }

    /**
     * Adding value into repository
     * @param value value to add
     * @return true, if adding successful and false if adding unsuccessful
     */
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

    /**
     * Removes value from repository
     * @param index index of removing value
     * @return removing value
     */
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

    /**
     * Sorting repository
     * @param comp compare logic
     */
    @Override
    public void sort(Comparator<T> comp) {
        sorter.sort(this,  comp);
    }

    /**
     * Get index of setting value
     * @param value setting value
     * @return index
     */
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
    public T get(int index) {
        if (index < 0 && index >= size) {
            return null;
        }
        return (T)rep[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<getSize(); i++) {
            sb.append(get(i).toString()).append("\n");
        }
        sb.append("size: ").append(getSize());
        return sb.toString();
    }

    protected abstract Repository<T> getRepositoryInstance(int size);

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
