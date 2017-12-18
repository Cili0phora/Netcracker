package repository.subjects.car.carChecker;

import repository.common.Checker;
import repository.subjects.car.Car;

public class SerialNumberCarChecker implements Checker<Car> {
    @Override
    public boolean check(Car p1, Object value) {
        return p1.getSerialNumber().equals(value.toString());
    }
}
