package Commands;

import MajorClasses.Person;
import MajorClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class RemoveAllByOwner implements Command {
    ArrayList<String> arrArgs;

    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException {
        boolean pass = false;
        System.out.println("---");
        if (collection.size() == 0) throw new IOException("Коллекция-то пуста . . .");
        while (!pass) {
            if (arrArgs.size() != 1) System.out.println("Пожалуйста, введите Owner's name");
            else {
                String inputName = arrArgs.get(0);
                boolean flag = false;
                for (Product elem : collection) {
                    String name = elem.getPerson().getName();
                    if (name.equals(inputName)){
                        collection.remove(elem);
                        flag = true;
                    }
                }
                pass = true;

                if (flag) {
                    System.out.println("Все продукты данного владельца успешно удалены!");
                    System.out.println("---");
                }
                else System.out.println("Данного владельца и так нет в коллекции . . .");
            }
            if (!pass) arrArgs = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
        }
    }
    @Override
    public void addArgs(ArrayList<String> arr) {
        this.arrArgs = arr;
    }
}