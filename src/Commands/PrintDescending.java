package Commands;

import MajorClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;

public class PrintDescending implements Command {

    ArrayList<String> args;
    @Override
    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException{
        System.out.println("---");
        if (args.size() != 0) System.out.println("Ой, ну ты меня балуешь :3 здесь не нужны аргументы :)");
        ArrayList<Product> arr = new ArrayList<>();
        arr.addAll(collection);
        arr.sort((o1, o2) -> Float.compare(o2.getPrice(), o1.getPrice())); // по убыванию
        ArrayDeque<Product> col2 = new ArrayDeque<>(arr);
        new Show().execute(col2, reader);
    }
    @Override
    public void addArgs(ArrayList<String> arr) {
        this.args = arr;
    }
}
