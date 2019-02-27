package sample.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
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

    @FXML
    private Button addGuest;

    @FXML
    private Button createReceipe;

    @FXML
    private HBox fav;

    @Override
    public void init(){
        super.init();

        addGuest.setOnAction(actionEvent -> this.router.change(Page.ADDGUEST));
        createReceipe.setOnAction(actionEvent -> this.router.change(Page.DISHCREATION));

        dishes = new ArrayList<>();

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader("src/sample/test.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Receipe receipe = gson.fromJson(reader, Receipe.class);

        dishes.add(new DishComponent(receipe));

        DishComponent bo = dishes.get(0);

        fav.getChildren().add(bo.getDish());
    }
}
