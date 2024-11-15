import java.io.Serializable;

public class Car implements Serializable {
    private String brand;
    private String model;
    private int seats;


    public Car(String brand, String model, int seats) {
        this.brand = brand;
        this.model = model;
        this.seats = seats;
    }

    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", seats=" + seats +
                '}';
    }
}
