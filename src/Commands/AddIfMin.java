package Commands;

import MajorClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class AddIfMin implements Command {
    ArrayList<String> arrArgs;

    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException {

        System.out.println("---");
        boolean pass = false;

        if (collection.size() == 0) throw new IOException("Коллекция-то пуста . . .");
        while (!pass) {
            if (arrArgs.size() != 1) System.out.println("Пожалуйста, введите число - price");
            else {
                try {
                    Float inputPrice =  Float.parseFloat(arrArgs.get(0));
                    Float minpr = Float.MAX_VALUE;

                    for (Product elem : collection){
                        Float price = elem.getPrice();
                        if (Float.compare(minpr, price) > 0){
                            minpr = price;
                        }
                    } if (Float.compare(minpr, inputPrice) > 0){
                        System.out.println("Происходит добавление элемента!");
                        Add add = new Add();
                        add.price = inputPrice;
                        add.addArgs(new ArrayList<>());
                        add.execute(collection, reader);
                        pass = true;
                    }else throw new IOException("Элемент не самый маленький, добавление не произошло!");

                } catch (NumberFormatException e) {
                    System.out.println("Введите ЧИСЛО . . .");
                }
            }
            if (!pass) arrArgs = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
        }
    }
    @Override
    public void addArgs(ArrayList<String> arr) {
        this.arrArgs = arr;
    }
}
