package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Page;

public class MealFinderController extends Controller {

    @FXML
    private Button addMeal;

    @Override
    public void init(){
        super.init();

        addMeal.setOnAction(actionEvent -> this.router.change(Page.FRIDGE));
    }
}
