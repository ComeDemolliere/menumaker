package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Page;


public class MenumakerController extends Controller{

    @FXML
    private Button starter;

    @FXML
    private Button mainCourse;

    @FXML
    private Button desert;


    public MenumakerController(){
    }

    @Override
    public void init(){
        super.init();

        //init bottom button
        starter.setOnAction(actionEvent -> this.router.change(Page.MEALFINDER));
        mainCourse.setOnAction(actionEvent -> this.router.change(Page.MEALFINDER));
        desert.setOnAction(actionEvent -> this.router.change(Page.MEALFINDER));
    }
}
