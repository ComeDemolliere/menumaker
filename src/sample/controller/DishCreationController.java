package sample.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import models.Ingredient;
import models.Receipe;
import sample.Page;
import sample.component.DishComponent;
import sample.component.DishWithDateComponent;
import sample.component.IngredientComponent;
import sample.view.DishCreation;
import sample.view.Meals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private TextField name;

    @FXML
    private Button addIngredient;

    @FXML
    private ListView<BorderPane> ingredients;

    @FXML
    private TextField ingredient;

    @FXML
    private TextField quantity;

    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private TextField currentDate;

    public DishCreationController(){
        this.ingredientList = new ArrayList<>();
    }

    @Override
    public void init(){
        super.init();
        ingredientList.clear();
        createDish.setOnAction(actionEvent -> storeDish());
        validateDish.setOnAction(actionEvent -> validateDish());
        addIngredient.setOnAction(actionEvent -> addIngredient());

        //date management
        Date date = new Date();
        currentDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(date));

        //update choiceBox
        ArrayList<String> units = new ArrayList<>();
        units.add("g");
        units.add("cL");
        units.add("unités");
        ObservableList<String> list1 = FXCollections.observableArrayList(units);
        choiceBox.setItems(list1);
    }

    private void addIngredient(){
        IngredientComponent currentIngredient = new IngredientComponent(new Ingredient(ingredient.getText(), Integer.parseInt(quantity.getText()),this.getSelectedUnit()));

        ingredientList.add(currentIngredient.getIngredient());
        ingredients.getItems().add(currentIngredient.getBorderPane());
    }

    private void storeDish(){
        Receipe currentReceipe = new Receipe("default_dish.png", name.getText(),
                receipe.getText(), ingredientList, false, "");

        ((MealsController) router.getController(Page.MEALS)).addDishToSug(new DishComponent(currentReceipe));
        router.change(Page.MEALS);
    }

    private void validateDish(){
        //update fridge
        FridgeController fridge = ((FridgeController) router.getController(Page.FRIDGE));
        for (Ingredient ingredient: ingredientList){
            fridge.addIngredient(ingredient);
        }

        Receipe currentReceipe = new Receipe("default_dish.png", name.getText(),
                receipe.getText(), ingredientList, true, currentDate.getText());

        ((MealsController) router.getController(Page.MEALS)).addDishToFav(new DishComponent(currentReceipe));
        ((MenumakerController) router.getController(Page.MENUMAKER)).addDish(new DishWithDateComponent(currentReceipe));
        ((MenumakerController) router.getController(Page.MENUMAKER)).updateMainPage();
        router.change(Page.MENUMAKER);
    }
    private String getSelectedUnit(){
        String unit = (String) this.choiceBox.getValue();
        if(unit == null || unit=="unités"){
            unit = "";
        }


        return unit;
    }
}
