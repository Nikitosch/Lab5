package Commands;

import MajorClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class RemoveLower implements Command {
    ArrayList<String> arrArgs;

    @Override
    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException {
        boolean pass = false;
        System.out.println("---");
        if (collection.size() == 0) throw new IOException("Коллекция-то пуста . . .");
        while (!pass) {
            if (arrArgs.size() != 1) System.out.println("Введите число - price");
            else {
                try {
                    Float inputPrice = Float.parseFloat(arrArgs.get(0));

                    for (Product elem : collection) {
                        Float price = elem.getPrice();
                        if (Float.compare(inputPrice, price) > 0) {
                            collection.remove(elem);
                        }
                    }
                    System.out.println("Все меньшие элементы успешно удалены!");
                    System.out.println("---");
                    pass = true;
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
