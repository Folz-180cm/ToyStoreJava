import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
    // Create a list of toys
    List<Toy> toys = new ArrayList<>();
    toys.add(new Toy(1, "Teddy Bear", 10, 100));
    toys.add(new Toy(2, "Toy Car", 5, 50));
    toys.add(new Toy(3, "Doll", 8, 80));

        // Print the details of each toy
        for (Toy toy : toys) {
            System.out.println("Toy id: " + toy.getId());
            System.out.println("Toy name: " + toy.getName());
            System.out.println("Toy quantity: " + toy.getQuantity());
            System.out.println("Toy weight: " + toy.getWeight());
    
            // Decrease the quantity of the toy by 1
            toy.decreaseQuantity();
            System.out.println("Toy quantity after decrease: " + toy.getQuantity());
    
            System.out.println("--------------------------");
        }
    
        // Write the details of each toy to a file
        try {
            FileWriter writer = new FileWriter("toys.txt");
            for (Toy toy : toys) {
                writer.write("Toy id: " + toy.getId() + "\n");
                writer.write("Toy name: " + toy.getName() + "\n");
                writer.write("Toy quantity: " + toy.getQuantity() + "\n");
                writer.write("Toy weight: " + toy.getWeight() + "\n\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Toy {
    private int id;
    private String name;
    private int quantity;
    private int weight;

    public Toy(int id, String name, int quantity, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void decreaseQuantity() {
        quantity--;
    }
}