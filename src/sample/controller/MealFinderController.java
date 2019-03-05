package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import models.Ingredient;
import sample.Page;
import sample.component.DishComponent;
import sample.component.DishWithDateComponent;
import sample.component.IngredientComponent;

import java.util.List;
import java.util.Random;

public class MealFinderController extends Controller {

    private int currentDish;
    private List<DishComponent> dishes;

    @FXML
    private Button addMeal;

    @FXML
    private Text name;

    @FXML
    private TextArea receipe;

    @FXML
    private ListView<BorderPane> ingredients;

    @FXML
    private ImageView image;

    @FXML
    private ImageView right;

    @FXML
    private ImageView left;

    @Override
    public void init(){
        super.init();

        //action events
        addMeal.setOnAction(actionEvent -> this.validate());
        right.setOnMouseClicked(event -> this.next());
        left.setOnMouseClicked(mouseEvent -> this.prev());

        if(dishes != null){
            image.setImage(new Image("sample/ressources/pictures/" + dishes.get(currentDish).getReceipe().getImage()));
            name.setText(dishes.get(currentDish).getReceipe().getName());
            receipe.setText(dishes.get(currentDish).getReceipe().getReceipe());
            dishes.get(currentDish).getReceipe().getIngredients().forEach(i -> {
                ingredients.getItems().add((new IngredientComponent(i)).getBorderPane());
            });
        }
    }

    public void updateDishes(List<DishComponent> dishes){
        this.dishes = dishes;

        Random rand = new Random();
        this.currentDish = rand.nextInt(dishes.size());
    }

    private void validate(){
        //update fridge
        FridgeController fridge = ((FridgeController) router.getController(Page.FRIDGE));
        for (Ingredient ingredient: dishes.get(currentDish).getReceipe().getIngredients()){
            fridge.addIngredient(ingredient);
        }

        ((MenumakerController) router.getController(Page.MENUMAKER)).addDish(new DishWithDateComponent(dishes.get(currentDish).getReceipe()));
        ((MenumakerController) router.getController(Page.MENUMAKER)).updateMainPage();
        router.change(Page.MENUMAKER);
    }

    private void next(){
        if(this.currentDish < dishes.size() - 1)
            this.currentDish += 1;
        else
            this.currentDish = 0;
        this.init();
    }

    private void prev(){
        if(this.currentDish > 0)
            this.currentDish -= 1;
        else
            this.currentDish = dishes.size()-1;
        this.init();
    }
}
