package MajorClasses;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Loader {

    public void autoload(ArrayDeque<Product> collection, String[] args) {
        String filename;
        if (args.length != 1) {
            System.out.println("Не загрузили файлик, ну запишем наш . . .");
            filename = "D:/Code/Java_progs/Lab5/test.yaml";
        } else filename = args[0];

        File file = new File(filename);

        // ok fine, no reflection ...

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String[] line;
            String value;
            Product product;

            while (reader.readLine() != null) { // ---

                reader.readLine(); // number

                product = new Product();

                line = reader.readLine().replaceAll("\\s+", "").split(":");
                value = line[1]; //id
                product.setId(Integer.parseInt(value));

                line = reader.readLine().replaceAll("\\s+", "").split(":");
                value = line[1]; //name
                product.setName(value);

                reader.readLine(); // Coordinates
                Coordinates coor = new Coordinates();

                line = reader.readLine().replaceAll("\\s+", "").split(":");
                value = line[1]; // x
                coor.setX(Double.parseDouble(value));

                line = reader.readLine().replaceAll("\\s+", "").split(":");
                value = line[1]; // y
                coor.setY(Long.parseLong(value));
                product.setCoordinates(coor);

                line = reader.readLine().replaceAll("\\s+", "").split(":");
                value = line[1]; // creationDate
                product.setCreationDate(java.time.LocalDate.parse(value));

                line = reader.readLine().replaceAll("\\s+", "").split(":");
                value = line[1]; // price
                product.setPrice(Float.parseFloat(value));

                line = reader.readLine().replaceAll("\\s+", "").split(":");
                value = line[1]; // parteNumber
                product.setPartNumber(value);

                line = reader.readLine().replaceAll("\\s+", "").split(":");
                value = line[1]; // UnitOfMeasure
                product.setUnitOfMeasure(UnitOfMeasure.valueOf(value));

                reader.readLine(); // Person
                Person owner = new Person();

                line = reader.readLine().replaceAll("\\s+", "").split(":");
                value = line[1]; // name
                owner.setPersonName(value);

                line = reader.readLine().replaceAll("\\s+", "").split(":");
                value = line[1]; // height
                owner.setPersonHeight(Long.parseLong(value));

                line = reader.readLine().replaceAll("\\s+", "").split(":");
                value = line[1]; // weight
                owner.setPersonHeight(Long.parseLong(value));

                line = reader.readLine().replaceAll("\\s+", "").split(":");
                value = line[1]; // Color
                owner.setPersonEyeColor(Color.valueOf(value));

                product.setOwner(owner);

                reader.readLine(); // ---

                collection.add(product);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Вронг фаел!");
        } catch (IOException e) {
            System.out.println("Что-то с вводом ...");
        }
    }
    public void historyMaker(String commWithArgs){

        try{
            String input;
            String command = commWithArgs.split(" ")[0];
            ArrayList<String> lines = new ArrayList<>();

            File targetFile = new File("history.txt");
            File tempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader (targetFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            while((input = reader.readLine())!= null) lines.add(input);

            if (lines.size() <= 13){
                lines.add(command);
                for (String line : lines) writer.write(line + "\n");

            } else {
                while (lines.size() > 13){
                    lines.remove(0);
                }
                lines.add(command);
                for (String line : lines) writer.write(line + "\n");
            }
            reader.close();
            writer.close();
            targetFile.delete();
            tempFile.renameTo(targetFile);
        }catch (IOException e){
            System.out.println("Что-то не то");
        }
    }
}
