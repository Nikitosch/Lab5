package Commands;

import MajorClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;

public interface Command {
    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException;

    public void addArgs(ArrayList<String> arr);
}
