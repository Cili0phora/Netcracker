package repository.subjects.car;

import java.util.Comparator;
import java.util.UUID;

public class Car {
    private String brand;
    private String serialNumber;
    private String id;

    public Car(String mark, String model, String serialNumber) {
        this.brand = model;
        this.serialNumber = serialNumber;
        id = UUID.randomUUID().toString();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getId() {
        return id;
    }

    public  int compareTo(Car c2, Comparator<Car> comp) {
        return comp.compare(this, c2);
    }
}
