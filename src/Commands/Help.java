package Commands;

import MajorClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;

public class Help implements Command {

    @Override
    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException {
        System.out.println("---");
        System.out.println("Доступные команды: ");
        System.out.println("info  --- вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println("show  --- вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add  {String name, Float price, String partNumber} -- и дальше читать подсказки программы  --- добавить новый элемент в коллекцию");
        System.out.println("update  {int id, желаемое поле} -- может повторяться -- для остановки ввести stop --- обновить поле элемента в коллекции");
        System.out.println("remove_by_id  {int id} --- удалить элемент из коллекции по его id");
        System.out.println("clear --- очистить коллекцию");
        System.out.println("save --- сохранить коллекцию в файл");
        System.out.println("execute_script {file name} --- считать и исполнить скрипт из указанного файла");
        System.out.println("exit --- завершить программу (без сохранения в файл)");
        System.out.println("add_if_min {Float price} -- и затем остальные аргументы --- добавить новый элемент в коллекцию, если его значение price меньше, чем у наименьшего элемента этой коллекции");
        System.out.println("remove_lower {Float price} --- удалить из коллекции все элементы, меньшие по цене, чем заданный");
        System.out.println("history --- вывести последние 14 команд (без их аргументов)");
        System.out.println("remove_all_by_owner {String name} --- удалить из коллекции все элементы, значение поля Person.name которого эквивалентно заданному");
        System.out.println("group_counting_by_part_number --- сгруппировать элементы коллекции по значению поля partNumber, вывести количество элементов в каждой группе");
        System.out.println("print_descending --- вывести элементы коллекции в порядке убывания");
        System.out.println("---");
    }

    @Override
    public void addArgs(ArrayList<String> arr) {}
}
