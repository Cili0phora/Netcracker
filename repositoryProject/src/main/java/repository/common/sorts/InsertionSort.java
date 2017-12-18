package repository.common.sorts;

import repository.common.AbstractRepository;
import repository.common.ISort;

import java.util.Comparator;

public class InsertionSort implements ISort {
    @Override
    public void sort(AbstractRepository rep, Comparator comp) {
        int j;
        Object temp;
        for (int i = 0; i<rep.getSize()-1; i++) {
            if (comp.compare(rep.getRep()[i], rep.getRep()[i+1]) > 0) {
                temp = rep.getRep()[i+1];
                rep.getRep()[i+1] = rep.getRep()[i];
                j = i;
                while (j > 0 && comp.compare(temp, rep.getRep()[j-1]) < 0) {
                    rep.getRep()[j] = rep.getRep()[j-1];
                    j--;
                }
                rep.getRep()[j] = temp;
            }
        }
    }
}
