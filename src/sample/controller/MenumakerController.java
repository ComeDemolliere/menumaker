package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import models.Receipe;
import sample.Page;
import sample.component.DishComponent;
import sample.view.MealFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MenumakerController extends Controller{

    private List<DishComponent> dishes;
    private boolean isUpdate;

    @FXML
    private Button starter;

    @FXML
    private Button mainCourse;

    @FXML
    private Button desert;

    @FXML
    private Text info;

    @FXML
    private ListView<BorderPane> mealList;


    public MenumakerController(List<Receipe> receipes){
        dishes = new ArrayList<>();
        isUpdate = false;

        for (Receipe receipe: receipes) {
            if (receipe.isConsumed())
                dishes.add(new DishComponent(receipe));
        }
    }

    @Override
    public void init(){
        super.init();

        //init bottom button
        starter.setOnAction(actionEvent -> this.router.change(Page.MEALFINDER));
        mainCourse.setOnAction(actionEvent -> chooseDishForMe());
        desert.setOnAction(actionEvent -> this.router.change(Page.MEALFINDER));
        dishes.forEach(d -> mealList.getItems().add(0, d.getBorderPane()));

        //information
        if(isUpdate) info.setVisible(true);
        else info.setVisible(false);
        isUpdate = false;

    }

    private void chooseDishForMe(){
        MealFinderController finder = (MealFinderController) router.getController(Page.MEALFINDER);
        MealsController meals = (MealsController) router.getController(Page.MEALS);

        //get all dishes
        List<DishComponent> dishes = meals.getAllDishes();

        //choose randomly a dish
        Random rand = new Random();
        int alea = rand.nextInt(dishes.size());

        //update view
        finder.setCurrentDish(new DishComponent(dishes.get(alea).getReceipe()));
        this.router.change(Page.MEALFINDER);

    }

    public void addDish(DishComponent dishComponent){
        dishes.add(dishComponent);
    }

    public void updateMainPage(){
        isUpdate = true;
    }
}
