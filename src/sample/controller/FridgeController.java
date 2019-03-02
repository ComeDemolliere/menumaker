package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import models.Ingredient;
import sample.component.IngredientComponent;

import java.util.ArrayList;
import java.util.List;

public class FridgeController extends Controller {

    private List<IngredientComponent> fridgeIngredients;
    private List<IngredientComponent> shopIngredients;

    @FXML
    private ListView<BorderPane> fridgeList;

    @FXML
    private Button delIngInFridge;

    @FXML
    private TextField fridgeIng;

    @FXML
    private TextField fridgeQuantity;

    @FXML
    private Button addIngInFridge;

    @FXML
    private ListView<BorderPane> shopList;

    @FXML
    private Button delIngInShop;

    @FXML
    private TextField shopIng;

    @FXML
    private TextField shopQuantity;

    @FXML
    private Button addIngInShop;

    public FridgeController(List<Ingredient> ingredients){
        this.shopIngredients = new ArrayList<>();
        this.fridgeIngredients = new ArrayList<>();

        ingredients.forEach(ingredient -> fridgeIngredients.add(new IngredientComponent(ingredient)));
    }

    @Override
    public void init(){
        super.init();
        fridgeIngredients.forEach( i -> fridgeList.getItems().add(i.getBorderPane()));
        shopIngredients.forEach( i -> shopList.getItems().add(i.getBorderPane()));

        //delete action
        delIngInFridge.setOnAction(actionEvent -> deleteIngInfridge());
        delIngInShop.setOnAction(actionEvent -> deleteIngInShop());

        //add action
        addIngInFridge.setOnAction(actionEvent -> addIngInFridge());
        addIngInShop.setOnAction(actionEvent -> addIngInShop());
    }

    private void deleteIngInfridge(){
        int index = fridgeList.getSelectionModel().getSelectedIndex();
        if(index >= 0){
            fridgeIngredients.remove(index);
            fridgeList.getItems().remove(index);
        }
    }

    private void deleteIngInShop(){
        int index = shopList.getSelectionModel().getSelectedIndex();
        if(index >= 0){
            shopIngredients.remove(index);
            shopList.getItems().remove(index);
        }
    }

    private void addIngInFridge(){
        Ingredient ingredient= new Ingredient(fridgeIng.getText(), Integer.parseInt(fridgeQuantity.getText()));
        fridgeIngredients.add(0, new IngredientComponent(ingredient));
        fridgeList.getItems().add(0, fridgeIngredients.get(0).getBorderPane());
    }

    private void addIngInShop(){
        Ingredient ingredient= new Ingredient(shopIng.getText(), Integer.parseInt(shopQuantity.getText()));
        shopIngredients.add(0, new IngredientComponent(ingredient));
        shopList.getItems().add(0, shopIngredients.get(0).getBorderPane());
    }
}
