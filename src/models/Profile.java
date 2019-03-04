package models;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String name;
    private List<Ingredient> ingredientsNotGood;

    public Profile(String name) {
        this.name = name;
        ingredientsNotGood = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public List<Ingredient> getIngredientsNotGood(){
        return this.ingredientsNotGood;
    }

    public void addIngredient(Ingredient ingredient){
        ingredientsNotGood.add(ingredient);
    }
    public void removeIngredient(Ingredient ingredient){
        this.ingredientsNotGood.remove(ingredient);
    }

}
