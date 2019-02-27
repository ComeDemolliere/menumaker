package models;

import java.util.List;

public class Receipe {

    private String name;
    private String receipe;
    private List<Ingredient> ingredients;

    public String getName(){
        return this.name;
    }

    public List<Ingredient> getIngredients(){
        return this.ingredients;
    }
}
