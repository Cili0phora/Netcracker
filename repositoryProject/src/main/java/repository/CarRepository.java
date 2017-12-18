package repository;

import repository.common.AbstractRepository;
import repository.common.Checker;
import repository.subjects.car.Car;
import repository.subjects.car.carChecker.BrandCarChecker;
import repository.subjects.car.carChecker.SerialNumberCarChecker;

public class CarRepository extends AbstractRepository<Car>{
    public CarRepository(int size) {
        setRep(new Car[size]);
    }

    public CarRepository(Car[] cars) {
        setRep(cars);
    }
    @Override
    protected CarRepository search(Checker<Car> checker, Object value) {
        CarRepository result = new CarRepository(getSize());
        for (int i = 0; i<getSize(); i++) {
            if (checker.check((Car)getRep()[i], value))
                result.add((Car)getRep()[i]);
        }
        return result;
    }

    public CarRepository searchByBrand(String brand) {
        return (CarRepository)search(new BrandCarChecker(), brand);
    }

    public CarRepository searchBySerialNumber(String brand) {
        return (CarRepository)search(new SerialNumberCarChecker(), brand);
    }

}
