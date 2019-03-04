package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import models.Ingredient;
import models.Profile;
import sample.Page;
import sample.component.IngredientComponent;

public class CreateProfileController extends Controller {

    private Profile profile = new Profile();
    @FXML
    private TextField profileName;

    @FXML
    private TextField ingredient;

    @FXML
    private Button addIngredientButton;

    @FXML
    private Button addProfileButton;

    @FXML
    private ListView<BorderPane> listIngredient;

    @FXML
    private Button removeIngredientButton;


    @Override
    public void init() {
        super.init();
        addIngredientButton.setOnAction(actionEvent -> this.addIngredient());
        addProfileButton.setOnAction(actionEvent -> this.addProfile());
        removeIngredientButton.setOnAction(actionEvent -> this.removeIngredient());
    }

    private void removeIngredient() {
        int index = listIngredient.getSelectionModel().getSelectedIndex();
        this.listIngredient.getItems().remove(index);
    }

    private void addIngredient() {
        Ingredient ingredient = new Ingredient(this.ingredient.getText(), 0);
        listIngredient.getItems().add(new IngredientComponent(ingredient).getBorderPane());
        profile.addIngredient(ingredient);
    }

    private void addProfile() {
        profile.setName(profileName.getText());
        AccountController accountController = (AccountController) this.router.getController(Page.ACCOUNT);
        accountController.addProfile(profile);
        profile = new Profile();
        this.router.change(Page.ACCOUNT);
    }
}
