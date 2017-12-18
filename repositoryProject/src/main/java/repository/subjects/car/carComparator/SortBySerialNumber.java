package repository.subjects.car.carComparator;

import repository.subjects.car.Car;

import java.util.Comparator;

public class SortBySerialNumber implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getSerialNumber().compareTo(o2.getSerialNumber());
    }
}
