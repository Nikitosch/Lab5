package Commands;

import MajorClasses.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class History implements Command {
    ArrayList<String> args;
    @Override
    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException {

        System.out.println("---");

        if (args.size() != 0) System.out.println("Ой, ну ты меня балуешь :3 здесь не нужны аргументы :)");

        File file = new File("history.txt");
        try (BufferedReader rdr = new BufferedReader(new FileReader(file))){
            String line;

            System.out.println("История последних 14 команд:");

            while ((line = rdr.readLine()) != null) System.out.println(line);

            System.out.println("---");

        }catch (IOException e){
            System.out.println("Что-то не так с историей!!");
        }
    }

    @Override
    public void addArgs(ArrayList<String> arr) {
        this.args = arr;
    }
}