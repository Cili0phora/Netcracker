package repository;

import repository.common.repositoryes.AbstractRepository;
import repository.common.Checker;
import repository.common.repositoryes.Repository;
import repository.subjects.car.Car;
import repository.subjects.car.carChecker.BrandCarChecker;
import repository.subjects.car.carChecker.SerialNumberCarChecker;

public class CarRepository extends AbstractRepository<Car>{
    /**
     * Constructor, creating empty repository with setting size
     * @param size setting size
     */
    public CarRepository(int size) {
        this.rep = new Car[size];
        this.size = 0;
    }

    /**
     * Contructor, creating repository for setting car array
     * @param cars setting array
     */
    public CarRepository(Car[] cars) {
        this.rep = cars;
        this.size = cars.length;
    }
    /**
     * Find all car's with setting brand
     * @param brand setting brand
     * @return repository of result persons
     */
    public CarRepository searchByBrand(String brand) {
        return (CarRepository)search(new BrandCarChecker(), brand);
    }

    /**
     * Find all car's with setting serialNumber
     * @param serialNumber setting serialNumber
     * @return
     */
    public CarRepository searchBySerialNumber(String serialNumber) {
        return (CarRepository)search(new SerialNumberCarChecker(), serialNumber);
    }

    @Override
    protected Repository<Car> getRepositoryInstance(int size) {
        return new CarRepository(size);
    }
}
