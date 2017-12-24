package repository.common.sorts;

import repository.common.repositoryes.AbstractRepository;
import repository.common.ISort;

import java.util.Comparator;

public class BubbleSort implements ISort {
    @Override
    public void sort(AbstractRepository rep, Comparator comp) {
        for (int i = 0; i<rep.getSize()-1; i++) {
            for (int j = 0; j<rep.getSize()-1; j++) {
                if(comp.compare(rep.getRep()[j], rep.getRep()[j+1]) > 0) {
                    Object temp = rep.getRep()[j];
                    rep.getRep()[j] = rep.getRep()[j+1];
                    rep.getRep()[j+1] = temp;
                }
            }
        }
    }
}
