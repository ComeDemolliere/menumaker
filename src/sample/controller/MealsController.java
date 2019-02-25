package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import models.Ingredient;
import sample.Page;
import sample.component.DishComponent;

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
        dishes.add(new DishComponent());

        DishComponent bo = dishes.get(0);
        bo.load();
       // bo.setDish( "test", new ArrayList<Ingredient>());
        if(bo.getDish() == null){
            System.out.println("test");
        }
        fav.getChildren().add(bo.getDish());
    }
}
