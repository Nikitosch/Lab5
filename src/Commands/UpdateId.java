package Commands;

import MajorClasses.Product;
import MajorClasses.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;

public class UpdateId implements Command {

    ArrayList<String> arrArgs;
    @Override
    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException{

        System.out.println("---");
        Setter setter = new Setter();
        Product updProduct = setter.idCheck(arrArgs, reader, collection);
        setter.update(updProduct,reader);
        System.out.println("---");
    }

    @Override
    public void addArgs(ArrayList<String> arr) {

    }
}
