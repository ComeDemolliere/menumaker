package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import models.Receipe;
import sample.Page;
import sample.component.DishComponent;
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
    private TextField search;

    @FXML
    private ListView<BorderPane> fav;

    @FXML
    private ListView<BorderPane> sug;

    @FXML
    private Button viewDishFav;

    @FXML
    private Button viewDishSug;

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
        viewDishFav.setOnAction(actionEvent -> validateDishfav());
        viewDishSug.setOnAction(actionEvent -> validateDishSug());
        search.setOnKeyTyped(actionEvent -> this.search());
    }

    public List<DishComponent> getAllDishes(){
        List<DishComponent> res = new ArrayList<>(this.dishesfav);
        res.addAll(this.dishesSug);
        return res;
    }

    public void addDishToSug(DishComponent dishComponent){
        dishesSug.add(0, dishComponent);
    }

    public void addDishToFav(DishComponent dishComponent){
        dishesfav.add(dishComponent);
    }

    private void validateDishfav() {
        DishValidationController dishController = (DishValidationController) this.router.getController(Page.DISHVALIDATION);

        int index = fav.getSelectionModel().getSelectedIndex();

        if(index >= 0){
            dishController.setReceipe(dishesfav.get(index).getReceipe());
            router.change(Page.DISHVALIDATION);
        }
    }

    private void search(){
        String res = search.getText();
        fav.getItems().clear();
        sug.getItems().clear();

        dishesfav.forEach(d -> {
            if(d.getReceipe().getName().toLowerCase().contains(res.toLowerCase()))
                fav.getItems().add(d.getBorderPane());
        });
        dishesSug.forEach(d -> {
            if(d.getReceipe().getName().toLowerCase().contains(res.toLowerCase()))
                sug.getItems().add(d.getBorderPane());
        });
    }

    private void validateDishSug() {
        DishValidationController dishController = (DishValidationController) this.router.getController(Page.DISHVALIDATION);

        int index = sug.getSelectionModel().getSelectedIndex();

        if(index >= 0){
            dishController.setReceipe(dishesSug.get(index).getReceipe());
            router.change(Page.DISHVALIDATION);
        }
    }
}
