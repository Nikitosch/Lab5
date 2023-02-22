import Commands.Command;
import MajorClasses.CommandMap;
import MajorClasses.Loader;
import MajorClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayDeque;

//Запуск через терминал ))
// java -cp out\production\Lab5 Main test.yaml
// java -cp out/production/Lab5 Main test.yaml    Windows же !)


//Everything is ready! Go!!!

public class Main {
    public static void main(String[] args) {

        System.out.println("Доброго времени суток!");

        ArrayDeque<Product> collection = new ArrayDeque<>();
        Loader loader = new Loader();
        loader.autoload(collection, args);

        CommandMap map = new CommandMap(LocalDate.now());
        String input = "";

        while (!input.equals("exit")) {

            System.out.println("Пожалуйста, введите команду:                  Введите help для просмотра доступных команд");
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                input = reader.readLine();
                Command command = map.getCommand(input);
                command.execute(collection, reader);
                // if command is not executed, catch exception and don't write in history.
                loader.historyMaker(input);
                if (input.equals("exit")) reader.close();
            } catch (NullPointerException e) {

                System.out.println("Неправильная команда, пожалуйста, попробуйте еще раз.");

            } catch (IOException e) {
                if (e.getMessage().equals("Программа завершила работу, всего хорошего!")){
                    System.out.println(e.getMessage());
                    input = "exit";
                    loader.historyMaker("exit");
                }
            }
        }
    }
}