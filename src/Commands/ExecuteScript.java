package Commands;

import MajorClasses.CommandMap;
import MajorClasses.Loader;
import MajorClasses.Product;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class ExecuteScript implements Command {

    ArrayList<String> args;
    @Override
    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException{

        System.out.println("---");
        System.out.println("Приказ будет исполнен . . .");

        if (args.size() != 1) {
            System.out.println("Один аргументик на вход пожалуйста --- имя файла ovO");
        } else {
            String filename = args.get(0);

            File file = new File(filename);

            try (BufferedReader rdr = new BufferedReader(new FileReader(file))) {

                CommandMap map = new CommandMap(LocalDate.now());
                Loader loader = new Loader();
                String input;
                if ((input = rdr.readLine()) == null) System.out.println("А файлик-то пустышка!");

                while (input != null) {
                    Command command = map.getCommand(input);
                    command.execute(collection, reader);
                    // if command is not executed, catch exception and don't write in history.
                    loader.historyMaker(input);
                    input = rdr.readLine();
                }
                System.out.println("Скрипт успешно исполнен!!!");
                System.out.println("---");
            }catch (FileNotFoundException e) {
                System.out.println("Ай-яй-яй! Вронг фаел!");
            }
        }
    }

    @Override
    public void addArgs(ArrayList<String> arr) {
        this.args = arr;
    }
}
