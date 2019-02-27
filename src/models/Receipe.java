package models;

import java.util.List;

public class Receipe {

    private String file_image;
    private String name;
    private String receipe;
    private List<Ingredient> ingredients;
    private boolean consumed;

    public Receipe(String file_image, String name, String receipe, List<Ingredient> ingredients, boolean consumed){
        this.file_image = file_image;
        this.name = name;
        this.receipe = receipe;
        this.ingredients = ingredients;
        this.consumed = consumed;
    }

    public String getName(){
        return this.name;
    }

    public List<Ingredient> getIngredients(){
        return this.ingredients;
    }

    public String getImage(){
        return this.file_image;
    }

    public boolean isConsumed(){
        return this.consumed;
    }
}
