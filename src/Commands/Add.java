package Commands;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Random;
import java.util.ArrayList;

import MajorClasses.Product;
import MajorClasses.Setter;

public class Add implements Command {
    ArrayList<String> arrArgs;
    public Float price = null;

    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException {

        System.out.println("---");

        Product newProduct = new Product();
        Random random = new Random();
        newProduct.setId(100000 + random.nextInt(900000)); // random 6 - digit id

        java.time.LocalDate date = java.time.LocalDate.now();
        newProduct.setCreationDate(date);

        Setter setter = new Setter();
        if (this.price != null) setter.price = this.price;
        setter.setAll(newProduct,arrArgs,reader);
        collection.add(newProduct);
        System.out.println("Элемент успешно добавлен!");
        System.out.println("---");
    }

    @Override
    public void addArgs(ArrayList<String> arr) {
        this.arrArgs = arr;
    }
}
