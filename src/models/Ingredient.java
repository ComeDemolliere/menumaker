package models;

public class Ingredient {

    private String title;
    private int amount;

    public Ingredient(String title, int amount){
        this.title = title;
        this.amount = amount;
    }

    public String getTitle(){
        return this.title;
    }

    public int getAmount(){
        return this.amount;
    }
}
