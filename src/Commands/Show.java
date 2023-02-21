package Commands;

import MajorClasses.Coordinates;
import MajorClasses.Person;
import MajorClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.SortedMap;

public class Show implements Command {

    ArrayList<String> args;
    @Override
    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException{
        if (this.args != null && args.size() != 0) System.out.println("Ой, ну ты меня балуешь :3 здесь не нужны аргументы :)");
        int cnt = 1;
        for (Product element : collection){
            System.out.println("----------");
            System.out.println(cnt++ + ":");
            System.out.println("  id: " + element.getId());
            System.out.println("  name: " + element.getName());
            System.out.println("  Coordinates:");
            Coordinates coordinates = element.getCoordinates();
            System.out.println("       - x : " + coordinates.getX());
            System.out.println("       - y : " + coordinates.getY());
            System.out.println("  creationDate: " + element.getCreationDate());
            System.out.println("  price: " + element.getPrice());
            System.out.println("  partNumber: " + element.getPartNumber());
            System.out.println("  UnitOfMeasure: " + element.getUnitOfMeasure());
            Person owner = element.getOwner();
            System.out.println("  Person:");
            System.out.println("       - name : " + owner.getPersonName());
            System.out.println("       - height : " + owner.getPersonHeight());
            System.out.println("       - weight : " + owner.getPersonWeight());
            System.out.println("       - Color : " + owner.getPersonEyeColor());
            System.out.println("----------");
        }
    }
    @Override
    public void addArgs(ArrayList<String> arr) {
        this.args = arr;
    }
}
