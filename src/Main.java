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
        System.out.println("Comienza programa");
        write();
        read();
        System.out.println("Programa terminado");
    }

    //Writing a byte file (objects.data)
    public void write() {
        System.out.println("Creando array de objetos car");
        Car[] cars = new Car[3];
        cars[0] = new Car("Opel", "Zafira", 5);
        cars[1] = new Car("Ford", "Fiesta", 5);
        cars[2] = new Car("Ford", "Focus", 5);
        System.out.println("Array creado con "+cars.length+" elementos");
        try(FileOutputStream fileOut = new FileOutputStream("objects.data");
        ObjectOutputStream output = new ObjectOutputStream(fileOut)) {
            for (Car car: cars) {
                output.writeObject(car);
            }

            System.out.println("Operación de escritura en fichero terminada");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void read(){
        System.out.println("Empezando con operación de lectura de información desde fichero. Mostrando datos....");
        try(FileInputStream fileIn = new FileInputStream("objects.data");
        ObjectInputStream input = new ObjectInputStream(fileIn)) {
            while (true) {
                Car car = (Car) input.readObject();
                System.out.println(car.toString());
            }
        }catch(Exception e){
            //System.out.println(e);
        }
        System.out.println("Operación de lectura terminada");
    }
}