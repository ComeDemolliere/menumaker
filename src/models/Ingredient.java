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

    public void increaseAmount(int amount) {
        this.amount += amount;
    }

    public int decreaseAmount(int amount) {
        if(this.amount - amount >= 0){
            this.amount -= amount;
            return 0;
        }
        else{
            int rest = amount - this.amount;
            this.amount = 0;
            return rest;
        }
    }
}
