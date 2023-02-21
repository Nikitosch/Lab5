package MajorClasses;

public class Coordinates {

    private double x; //Значение поля должно быть больше -964
    private Long y; //Максимальное значение поля: 187, Поле не может быть null

    public double getX (){
        return this.x;
    }
    public void setX (double x){
        this.x = x;
    }
    public long getY (){
        return this.y;
    }
    public void setY (long y){
        this.y = y;
    }
}
