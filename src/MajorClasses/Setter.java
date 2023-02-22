package MajorClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
public class Setter {

    public Float price = null;
    public void setAll(Product newProduct, ArrayList<String> arr, BufferedReader reader) throws IOException {
        setProductFields(newProduct, arr, reader);
        setCoordinates(newProduct, reader);
        setUnitOfMeasure(newProduct, reader);
        setPersonOwner(newProduct, reader);
    }

    public void setProductFields(Product newProduct, ArrayList<String> arr, BufferedReader reader) throws IOException {
        boolean pass = false;
        while (!pass) {
            pass = true;
            if (arr.size() != 3 && this.price == null) {
                pass = false;
                System.out.println("Ошибка ввода, пожалуйста введите 3 поля в строку: name, price, partNumber");
            } else if (this.price != null && arr.size() != 2){
                System.out.println("Введите 2 поля в строку: name, partNumber, так как price уже установлена!");
                pass = false;
            } else {
                String x = arr.get(0);
                if ((x == null) || (x.equals(""))) {
                    System.out.println("Неправильное имя, пожалуйста, попробуйте еще раз");
                    pass = false;
                }
                if (this.price == null) {
                    x = arr.get(1);
                    if (!(intCheck(x) && (Integer.parseInt(x) > 0))) {
                        pass = false;
                        System.out.println("Wrong input, введите цену больше нуля");
                    }
                    x = arr.get(2);
                } else x = arr.get(1);
                if (!(x.length() >= 15) && (x.length() < 98) && (!x.equals(""))) {
                    pass = false;
                    System.out.println("Введите partNumber длиной не меньше 15");
                }
            }
            if (!pass) {
                System.out.println("Чтобы прекратить, введите stop");
                arr = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
                if (arr.get(0).equals("stop")) throw new IOException("Сброс команды");
            }
        }
        newProduct.setName(arr.get(0));
        if (this.price == null){
            newProduct.setPrice(Float.valueOf(arr.get(1)));
            newProduct.setPartNumber(arr.get(2));
        }
        else {
            newProduct.setPrice(this.price);
            newProduct.setPartNumber(arr.get(1));
        }
    }

    public void setCoordinates(Product newProduct, BufferedReader reader) throws IOException {

        System.out.println("Введите координаты: x > -964, y <= 187");
        boolean pass = false;

        while (!pass) {

            String[] input = reader.readLine().replaceAll("[,;:]", "").split(" ");
            if (input.length != 2) System.out.println("Введите две координаты! Хватит пакостить");

            else if (intCheck(input[0]) && intCheck(input[1]) && (Integer.parseInt(input[0]) > -964)
                    && (Integer.parseInt(input[1]) <= 187)) {
                pass = true;
                Coordinates coor = new Coordinates();
                coor.setX(Double.parseDouble(input[0]));
                coor.setY(Long.parseLong(input[1]));
                newProduct.setCoordinates(coor);
            } else {
                System.out.println("Неправильные координаты! Ну что ж такое ...");
            }
        }
    }

    public void setUnitOfMeasure(Product newProduct, BufferedReader reader) throws IOException {
        System.out.println("Выберите единицу измерения:\nSQUARE_METERS\n" +
                "MILLILITERS\n" +
                "GRAMS");
        boolean pass = false;
        while (!pass) {
            String input = reader.readLine();
            if (!("SQUARE_METERS~~~MILLILITERS~~~GRAMS").contains(input))
                System.out.println("-____- Попробуйте еще раз:\n" +
                        "Выберите единицу измерения:\nSQUARE_METERS\n" +
                        "MILLILITERS\n" +
                        "GRAMS");
            else {
                pass = true;
                newProduct.setUnitOfMeasure(UnitOfMeasure.valueOf(input));
            }
        }
    }

    public void setPersonOwner(Product newProduct, BufferedReader reader) throws IOException {

        Person npc = new Person();
        System.out.println("Введите name, height, weight:");
        System.out.println("Чтобы прекратить, введите stop");
        boolean pass = false;

        while (!pass) {
            String[] input = reader.readLine().replaceAll("[,;:]", "").split(" ");
            if (input[0].equals("stop")) throw new IOException("Сброс команды");
            if (input[0] == null || input[0].equals("")) {
                System.out.println("Введите не пустую строку");
            } else if (!(intCheck(input[1]) && intCheck(input[2]))) {
            } else if (Integer.parseInt(input[1]) <= 0 || (Integer.parseInt(input[2]) <= 0)) {
                System.out.println("Числа должны быть больше нуля!");
            } else {
                pass = true;
                npc.setName(input[0]);
                npc.setHeight(Long.parseLong(input[1]));
                npc.setWeight(Long.parseLong(input[2]));
            }
        }
        System.out.println("Выберите цвет Глаза:\n" +
                "RED\n" +
                "BLACK\n" +
                "YELLOW\n" +
                "BROWN");
        String s = "RED<>BLACK<>YELLOW<>BROWN";
        pass = false;
        while (!pass) {
            String color = reader.readLine();
            if (s.contains(color)) {
                pass = true;
                npc.setEyeColor(Color.valueOf(color));
            } else {
                System.out.println("Вот это да! Попробуйте еще раз\nВыберите цвет Глаза:\n" +
                        "RED,\n" +
                        "BLACK\n" +
                        "YELLOW\n" +
                        "BROWN");
            }
        }
        newProduct.setPerson(npc);
    }

    public void update(Product product, BufferedReader reader) throws IOException {
        System.out.println();
        System.out.println("Введите поле, которое хотите заменить, и значение, через равно. Например: name = Jhon");
        System.out.println("UnitOfMeasure считаем за простое поле: UnitOfMeasure = GRAMS");
        System.out.println();
        System.out.println("Для ввода составного типа используйте пример: Coordinates: x = 11, y = 22");
        System.out.println("Чтобы прекратить, введите stop");
        System.out.println();
        while (true) {
            ArrayList<String> splitOne = new ArrayList<>(Arrays.asList(reader.readLine().replaceAll("\\s*;", "").split(":")));
            if ("stop, exit".contains(splitOne.get(0))) throw new IOException("Сброс команды");
            if (splitOne.size() == 1) {
                String[] str = splitOne.get(0).split("=");
                if (!("name,price,partNumber,UnitOfMeasure".contains(str[0]))) System.out.println("Ну нет такого поля!");
                else if (str[0].equals("UnitOfMeasure") && (!"SQUARE_METERS,MILLILITERS,GRAMS".contains(str[1]))) {
                    System.out.println("Нет таких единиц измерения. Что за бред!");

                } else if (str[0].equals("price") && (!intCheck(str[1]) || (Integer.parseInt(str[1])) <= 0)) {
                    System.out.println("Цена должна быть числом больше нуля");
                } else {
                    updEasyField(product, splitOne.get(0));
                    System.out.println("Поле успешно изменено!");
                    System.out.println("Введите следующее поле, или stop чтобы завершить");
                    System.out.println();
                }
            } else if (splitOne.size() != 2) System.out.println("Ошибка ввода");
            else {

                String type = splitOne.get(0);
                ArrayList<String> splitTwo = new ArrayList<>(Arrays.asList(splitOne.get(1).replaceAll(" ", "").split(","))); //[x=11,y=22]

                if (!("Coordinates, Person".contains(type))) System.out.println("Какой-то мутный тип!!");

                else if ("Coordinates".equals(type) && (!((splitTwo.get(0).split("=")[0]).equals("x"))
                        || (!((splitTwo.get(1).split("=")[0]).equals("y"))))) {

                    System.out.println("У координат поля должны быть x или y");

                } else if ((("Person".equals(type))) && (((splitTwo.size() > 0) && !(splitTwo.get(0).split("=")[0].equals("name")))
                            && ((splitTwo.size() > 1) && !(splitTwo.get(1).split("=")[0].equals("height")))
                            && ((splitTwo.size() > 2) && !(splitTwo.get(2).split("=")[0].equals("weight")))
                            && ((splitTwo.size() > 3) && !(splitTwo.get(3).split("=")[0].equals("eyeColor"))))){
                        System.out.println("Вы ошиблись с Персоной ...");
                    } else {
                    for (String elem : splitTwo) {
                        String[] elems = elem.split("=");
                        String name = elems[0], value = elems[1];
                        if (name.equals("x") && (!intCheck(value) || Integer.parseInt(value) <= -964)) {
                            System.out.println("Неправильный икс");

                        } else if (name.equals("y") && (!intCheck(value) || Integer.parseInt(value) > 187)) {
                            System.out.println("Неправильный игорь");

                        } else if ("height,weight".contains(name) && (!intCheck(value) || Integer.parseInt(value) <= 0)) {
                            System.out.println("Странные параметры для человека ...");

                        } else if (name.equals("eyeColor") && (!("RED,BLACK,YELLOW,BROWN".contains(value)))) {
                            System.out.println("Ну нет такого цвета глаз! Что за вздор ...");

                        } else {
                            updHardField(type, product, splitTwo);
                            System.out.println("Поля успешно изменены! Невероятно!!");
                            System.out.println("Введите следующее поле или stop чтобы закончить");
                            System.out.println();
                        }
                    }
                }
            }
        }
    }

    public void updHardField(String type, Product product, ArrayList<String> elems) {

        try {
            Method method = Product.class.getMethod("get" + type.substring(0, 1).toUpperCase() + type.substring(1));
            Object classField = method.invoke(product); // ex. Coordinates coors =  getCoordinates() // not Class<?> classField!!!

            for (String elem : elems) {
                String[] args = elem.split("="); // x=11 -> [x, 11]
                String perem = args[0];
                Class<?> argtype = String.class;
                if (perem.equals("x")) argtype = double.class;
                else if ("y, height, weight".contains(perem)) argtype = long.class;
                else if (perem.equals("eyeColor")) argtype = Color.class;

                Method method2 = classField.getClass().getMethod("set" + perem.substring(0, 1).toUpperCase() + perem.substring(1), argtype); //setX()
                if (perem.equals("x")) {
                    double value = Double.parseDouble(args[1]);
                    method2.invoke(classField, value);

                } else if ("y, height, weight".contains(perem)) {
                    long value = Long.parseLong(args[1]);
                    method2.invoke(classField, value);

                } else if (perem.equals("eyeColor")) {
                    Color value = Color.valueOf(args[1]);
                    method2.invoke(classField, value);
                } else {
                    String value = args[1];
                    method2.invoke(classField, value);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something is Bad......");
        }
    }

    public void updEasyField(Product product, String elem) {
        String[] elems = elem.split("=");
        String name = elems[0];

        try {
            Class<?> type = String.class;
            if (name.equals("price")) type = float.class;
            else if (name.equals("UnitOfMeasure")) type = UnitOfMeasure.class;

            Method updField = Product.class.getMethod("set" + name.substring(0, 1).toUpperCase() + name.substring(1), type);

            if (name.equals("price")) {
                float value = Float.parseFloat(elems[1]);
                updField.invoke(product, value);
            } else if (name.equals("UnitOfMeasure")) {
                UnitOfMeasure value = UnitOfMeasure.valueOf(elems[1]);
                updField.invoke(product, value);
            } else {
                String value = elems[1];
                updField.invoke(product, value);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something is wrong...");
        }
    }

    public Product idCheck(ArrayList<String> arr, BufferedReader reader, ArrayDeque<Product> collection) throws IOException {
        boolean pass = false;
        Product updateElem = null;
        while (!pass) {
            if (arr == null || arr.size() != 1) System.out.println("Пожалуйста, введите id элемента");
            else if (!(intCheck(arr.get(0)))) ;
            else {
                ArrayList<Integer> idlist = new ArrayList<>();
                if (collection.size() == 0) throw new IOException("Коллекция пуста!");
                else {
                    for (Product product : collection) {
                        idlist.add(product.getId());
                        if (product.getId() == Integer.parseInt(arr.get(0))) {
                            updateElem = product;
                            pass = true;
                        }
                    }
                    if (!pass) {
                        System.out.printf("Элемент с таким id не найден. Пожалуйста, попробуйте еще раз.\nДоступные id: %s\n", idlist);
                        System.out.println("Чтобы прекратить, введите stop");
                        System.out.println();
                    }
                }
            }
            if (!pass) {
                arr = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
                if (arr.get(0).equals("stop")) throw new IOException("Сброс команды");
            }
        }
        return updateElem;
    }

    public boolean intCheck (String x){
        try {
           if (Integer.parseInt(x) < (-Math.pow(2,31))){
               System.out.println("Число слишком маленькое!");
               return false;

           } else if(Integer.parseInt(x) > (Math.pow(2,31) - 1)){
               System.out.println("Число слишком !!");
               return false;

           } else return true;

        }catch (NumberFormatException e){
            System.out.println("Ну и ну, вместо числа вы прислали котика, спасибо -UwU-");
            return false;
        }
    }
}
