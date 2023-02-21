package Commands;

import MajorClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;

public class Clear implements Command{
    ArrayList<String> args;
    @Override
    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException{

        System.out.println("---");

        if (args.size() != 0) System.out.println("Ой, ну ты меня балуешь :3 здесь не нужны аргументы :)");

        if (collection.size() == 0) throw new IOException("Коллекция и так пуста!");

        collection.clear();
        System.out.println("Коллекция теперь пуста и ждёт новых друзей!");
        System.out.println("---");
    }

    @Override
    public void addArgs(ArrayList<String> arr) {
        this.args = arr;
    }
}
