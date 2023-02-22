package MajorClasses;

public class Product {

    private int id; // Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    ////// Не больше чем 2^31 = 10 цифр!!!
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float price; //Поле не может быть null, Значение поля должно быть больше 0
    private String partNumber; //Длина строки должна быть не меньше 15, Строка не может быть пустой, Длина строки не должна быть больше 98, Поле может быть null
    private UnitOfMeasure unitOfMeasure; //Поле может быть null
    private Person owner; //Поле не может быть null

    public int getId (){
        return this.id;
    }
    public void setId (int id){
        this.id = id;
    }
    public String getName (){
        return this.name;
    }
    public void setName (String name){
        this.name = name;
    }
    public Coordinates getCoordinates (){
        return this.coordinates;
    }
    public void setCoordinates (Coordinates coordinates){
        this.coordinates = coordinates;
    }
    public float getPrice (){
        return this.price;
    }
    public void setPrice (float price){
        this.price = price;
    }

    public java.time.LocalDate getCreationDate (){
        return this.creationDate;
    }
    public void setCreationDate (java.time.LocalDate date){
        this.creationDate = date;
    }
    public String getPartNumber (){
        return this.partNumber;
    }
    public void setPartNumber (String partNumber){
        this.partNumber = partNumber;
    }
    public UnitOfMeasure getUnitOfMeasure (){
        return this.unitOfMeasure;
    }
    public void setUnitOfMeasure (UnitOfMeasure unitOfMeasure){
        this.unitOfMeasure = unitOfMeasure;
    }
    public Person getPerson (){
        return this.owner;
    }
    public void setPerson (Person owner){
        this.owner = owner;
    }

}