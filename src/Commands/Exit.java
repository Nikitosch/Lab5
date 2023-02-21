package Commands;

import MajorClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;

public class Exit implements Command {

    ArrayList<String> args;
    @Override
    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException{
        if (args.size() != 0) System.out.println("Ой, ну ты меня балуешь :3 здесь не нужны аргументы :)");
        throw new IOException("Программа завершила работу, всего хорошего!");
    }

    @Override
    public void addArgs(ArrayList<String> arr) {
        this.args = arr;
    }
}
