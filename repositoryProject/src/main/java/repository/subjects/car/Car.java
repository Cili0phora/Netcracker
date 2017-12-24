package repository.subjects.car;

import java.util.Comparator;
import java.util.UUID;

public class Car {
    private String brand;
    private String serialNumber;
    private String id;

    public Car(String brand, String serialNumber) {
        this.brand = brand;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("brand: ").append(brand).append('\n');
        sb.append("serial number: ").append(serialNumber).append('\n');
        sb.append("id: ").append(id).append('\n');
        return sb.toString();
    }
}
