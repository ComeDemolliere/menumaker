package sample.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import models.Dishes;
import models.Ingredient;
import models.Receipe;
import sample.Page;
import sample.component.DishComponent;
import sample.view.DishView;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MealsController extends Controller {

    private List<DishComponent> dishes;
    private List<Receipe> receipes;

    @FXML
    private Button addGuest;

    @FXML
    private Button createReceipe;

    @FXML
    private HBox fav;

    public MealsController(List<Receipe> receipes){
        this.receipes = receipes;
        dishes = new ArrayList<>();
        receipes.forEach(d -> dishes.add(new DishComponent(d)));
    }

    @Override
    public void init(){
        super.init();

        addGuest.setOnAction(actionEvent -> this.router.change(Page.ADDGUEST));
        createReceipe.setOnAction(actionEvent -> this.router.change(Page.DISHCREATION));

        dishes.forEach(d -> fav.getChildren().add(d.getDish()));
    }
}
