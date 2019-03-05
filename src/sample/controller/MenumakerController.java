package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import models.Receipe;
import sample.Page;
import sample.component.DishComponent;
import sample.component.DishWithDateComponent;
import sample.view.MealFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MenumakerController extends Controller{

    private List<DishWithDateComponent> dishes;
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
                dishes.add(new DishWithDateComponent(receipe));
        }
    }

    @Override
    public void init(){
        super.init();

        //init bottom button
        mainCourse.setOnAction(actionEvent -> chooseDishForMe());
        dishes.forEach(d -> mealList.getItems().add(d.getBorderPane()));
        mealList.setOnMouseClicked(mouseEvent -> shawMeal());

        //information
        if(isUpdate) info.setVisible(true);
        else info.setVisible(false);
        isUpdate = false;

    }

    private void shawMeal(){
        DishValidationController dishController = (DishValidationController) this.router.getController(Page.DISHVALIDATION);
        int currentIndex = mealList.getSelectionModel().getSelectedIndex();
        if(currentIndex >= 0){
            dishController.setReceipe(dishes.get(currentIndex).getReceipe());
            router.change(Page.DISHVALIDATION);
        }
    }

    private void chooseDishForMe(){
        MealFinderController finder = (MealFinderController) router.getController(Page.MEALFINDER);
        MealsController meals = (MealsController) router.getController(Page.MEALS);

        //get all dishes
        List<DishComponent> dishes = meals.getAllDishes();

        //update view
        finder.updateDishes(dishes);
        this.router.change(Page.MEALFINDER);

    }

    public void addDish(DishWithDateComponent dishComponent){
        dishes.add(0, dishComponent);
    }

    public void updateMainPage(){
        isUpdate = true;
    }
}