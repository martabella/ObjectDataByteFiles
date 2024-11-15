import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.inicio();

    }

    public void inicio(){
        write();
        read();
    }

    //Writing a byte file (objects.data)
    public void write() {

        Car[] cars = new Car[3];
        cars[0] = new Car("Opel", "Zafira", 5);
        cars[1] = new Car("Ford", "Fiesta", 5);
        cars[2] = new Car("Ford", "Focus", 5);
        FileOutputStream fileOut = new FileOutputStream("objects.data");
        ObjectOutputStream output = new ObjectOutputStream(fileOut);
        for (int i = 0; i < cars.length; i++) {
            output.writeObject(cars[i]);
        }

        System.out.println("Operación de escritura terminada");
    }
    public void read(){
        FileInputStream fileIn = new FileInputStream("objects.data");
        ObjectInputStream input = new ObjectInputStream(fileIn);
        while (true) {
            Car car = (Car) input.readObject();
            System.out.println(car.toString());
        }
    }
}