package Commands;

import MajorClasses.Product;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Save implements Command {

    ArrayList<String> args;
    @Override
    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException{

        if (args.size() != 0) System.out.println("Ой, ну ты меня балуешь :3 здесь не нужны аргументы :)");
        System.out.println("---");
        System.out.println("Сохранение . . .");
        PrintStream goBack = System.out;
        System.setOut(new PrintStream(new File("test.yaml")));
        Command show = new Show();
        show.execute(collection,reader);
        System.setOut(goBack); // why not just System.out?
        System.out.println("Файл успешно сохранен!");
        System.out.println("---");
    }

    @Override
    public void addArgs(ArrayList<String> arr) {
        this.args = arr;
    }
}
