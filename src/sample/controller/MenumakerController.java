package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import models.Receipe;
import sample.Page;
import sample.component.DishComponent;

import java.util.ArrayList;
import java.util.List;


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
        mainCourse.setOnAction(actionEvent -> this.router.change(Page.MEALFINDER));
        desert.setOnAction(actionEvent -> this.router.change(Page.MEALFINDER));
        dishes.forEach(d -> mealList.getItems().add(0, d.getBorderPane()));

        //information
        if(isUpdate) info.setVisible(true);
        else info.setVisible(false);
        isUpdate = false;

    }

    public void addDish(DishComponent dishComponent){
        dishes.add(dishComponent);
    }

    public void updateMainPage(){
        isUpdate = true;
    }
}
