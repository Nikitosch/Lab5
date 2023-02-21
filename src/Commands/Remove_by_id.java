package Commands;

import MajorClasses.Product;
import MajorClasses.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Remove_by_id implements Command {

    ArrayList<String> args;

    @Override
    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException {
        System.out.println("---");
        Setter setter = new Setter();
        Product removedProduct = setter.idCheck(args, reader, collection);
        collection.remove(removedProduct);
        System.out.println("Элемент успешно удален!");
        System.out.println("---");
    }
    @Override
    public void addArgs(ArrayList<String> args) {
        this.args = args;
    }
}
