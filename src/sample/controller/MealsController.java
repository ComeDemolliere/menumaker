package sample.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
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

    private List<DishComponent> dishesfav;
    private List<DishComponent> dishesSug;

    @FXML
    private Button addGuest;

    @FXML
    private Button createReceipe;

    @FXML
    private ListView<BorderPane> fav;

    @FXML
    private ListView<BorderPane> sug;

    public MealsController(List<Receipe> receipes){
        dishesfav = new ArrayList<>();
        dishesSug = new ArrayList<>();

        for (Receipe receipe: receipes) {
            if(receipe.isConsumed())
                dishesfav.add(new DishComponent(receipe));
            else
                dishesSug.add(new DishComponent(receipe));
        }
    }

    @Override
    public void init(){
        super.init();

        addGuest.setOnAction(actionEvent -> this.router.change(Page.ADDGUEST));
        createReceipe.setOnAction(actionEvent -> this.router.change(Page.DISHCREATION));

        dishesfav.forEach(d -> fav.getItems().add(d.getBorderPane()));
        dishesSug.forEach(d -> sug.getItems().add(d.getBorderPane()));
    }

    public void addDishToSug(DishComponent dishComponent){
        dishesSug.add(dishComponent);
    }
}
