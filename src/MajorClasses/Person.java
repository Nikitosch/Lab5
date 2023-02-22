package MajorClasses;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long height; //Значение поля должно быть больше 0
    private long weight; //Значение поля должно быть больше 0
    private Color eyeColor; //Поле не может быть null

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHeight() {
        return this.height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getWeight() {
        return this.weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }
    public Color getEyeColor (){
        return this.eyeColor;
    }
    public void setEyeColor (Color eyeColor){
        this.eyeColor = eyeColor;
    }
}

