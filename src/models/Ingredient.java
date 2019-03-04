package models;

public class Ingredient {

    private String title;

    @Override
    public String toString() {
        return "Ingredient{" +
                "title='" + title + '\'' +
                '}';
    }

    private int amount;
    private String unit;


    public Ingredient(String title, int amount, String unit){
        this.title = title;
        this.amount = amount;
        this.unit = unit;
    }

    public String getTitle(){
        return this.title;
    }

    public int getAmount(){
        return this.amount;
    }

    public String getUnit(){
        return this.unit;
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
