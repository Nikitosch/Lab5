package Commands;

import MajorClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;

public class Info implements Command {
    java.time.LocalDate time;

    public Info(java.time.LocalDate time){
        this.time = time;
    }

    ArrayList<String> args;
    @Override
    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException{
        System.out.println("---");
        if (args.size() != 0) System.out.println("Ой, ну ты меня балуешь :3 здесь не нужны аргументы :)");
        Class<?> colType = collection.getClass();
        System.out.println("Информация о коллекции");
        System.out.println("Тип коллекции: " + colType);
        System.out.println("Дата инициализации: " + time);
        System.out.println("Количество объектов: " + collection.size());
        System.out.println("---");
        /// anything else?
    }

    @Override
    public void addArgs(ArrayList<String> arr) {
        this.args = arr;
    }
}
