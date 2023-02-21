package Commands;

import MajorClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class GroupCountingByPartNumber implements Command {
    @Override
    public void execute(ArrayDeque<Product> collection, BufferedReader reader) throws IOException {

        ArrayList<String> li = new ArrayList<>();
        ArrayList<Integer> cntLi = new ArrayList<>();
        String partNum;
        String last;
        for (Product elem : collection){
            partNum = elem.getPartNumber();
            if (!(li.contains(partNum))){
                li.add(partNum);
                cntLi.add(1);
            }else{
                cntLi.set(li.indexOf(partNum), cntLi.get(li.indexOf(partNum)) + 1); // увеличили счетчик на + 1
            }
        }
        System.out.println("---");
        for (int i = 0; i < cntLi.size(); i++){
            System.out.println("Элементов с номером " + li.get(i) + " в коллекции -- " + cntLi.get(i));
        }
        System.out.println("---");
    }

    @Override
    public void addArgs(ArrayList<String> arr) {
    }
}
