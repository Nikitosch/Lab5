package MajorClasses;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long height; //Значение поля должно быть больше 0
    private long weight; //Значение поля должно быть больше 0
    private Color eyeColor; //Поле не может быть null

    public String getPersonName() {
        return this.name;
    }

    public void setPersonName(String name) {
        this.name = name;
    }

    public long getPersonHeight() {
        return this.height;
    }

    public void setPersonHeight(long height) {
        this.height = height;
    }

    public long getPersonWeight() {
        return this.weight;
    }

    public void setPersonWeight(long weight) {
        this.weight = weight;
    }
    public Color getPersonEyeColor (){
        return this.eyeColor;
    }
    public void setPersonEyeColor (Color eyeColor){
        this.eyeColor = eyeColor;
    }
}

