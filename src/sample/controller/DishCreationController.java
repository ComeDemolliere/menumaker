package sample.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import models.Ingredient;
import models.Receipe;
import sample.Page;
import sample.component.DishComponent;
import sample.component.IngredientComponent;
import sample.view.DishCreation;
import sample.view.Meals;

import java.util.ArrayList;
import java.util.List;

public class DishCreationController extends Controller{

    private List<Ingredient> ingredientList;

    @FXML
    private Button createDish;

    @FXML
    private Button validateDish;

    @FXML
    private TextArea receipe;

    @FXML
    private Button addIngredient;

    @FXML
    private ListView<BorderPane> ingredients;

    @FXML
    private TextField ingredient;

    @FXML
    private TextField quantity;

    public DishCreationController(){
        this.ingredientList = new ArrayList<>();
    }

    @Override
    public void init(){
        super.init();
        createDish.setOnAction(actionEvent -> storeDish());
        validateDish.setOnAction(actionEvent -> this.router.change(Page.MENUMAKER));
        addIngredient.setOnAction(actionEvent -> addIngredient());
    }

    private void addIngredient(){
        IngredientComponent currentIngredient = new IngredientComponent(new Ingredient(ingredient.getText(), Integer.parseInt(quantity.getText())));

        ingredientList.add(currentIngredient.getIngredient());
        ingredients.getItems().add(currentIngredient.getBorderPane());
    }

    private void storeDish(){
        Receipe currentReceipe = new Receipe("default_dish.png", "test",
                receipe.getText(), ingredientList, false);

        ((MealsController) router.getController(Page.MEALS)).addDishToSug(new DishComponent(currentReceipe));
        router.change(Page.MEALS);
    }
}
