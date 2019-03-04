package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import models.Ingredient;
import models.Receipe;
import sample.Page;
import sample.component.DishComponent;
import sample.component.IngredientComponent;

public class DishValidationController extends Controller {

    private Receipe receipe;

    @FXML
    private ImageView image;

    @FXML
    private Text name;

    @FXML
    private TextArea receipeText;

    @FXML
    private ListView<BorderPane> ingredients;

    @FXML
    private Button validateDish;

    @Override
    public void init(){
        super.init();
        if(receipe != null){
            image.setImage(new Image("sample/ressources/pictures/" + receipe.getImage()));
            name.setText(receipe.getName());
            receipeText.setText(receipe.getReceipe());
            receipe.getIngredients().forEach(ingredient -> {
                ingredients.getItems().add(new IngredientComponent(ingredient).getBorderPane());
            });
        }

        validateDish.setOnAction(actionEvent -> validation());
    }

    public void setReceipe(Receipe receipe){
        this.receipe = receipe;
    }

    private void validation(){
        //update fridge
        FridgeController fridge = ((FridgeController) router.getController(Page.FRIDGE));
        for (Ingredient ingredient: receipe.getIngredients()){
            fridge.addIngredient(ingredient);
        }

        ((MenumakerController) router.getController(Page.MENUMAKER)).addDish(new DishComponent(receipe));
        ((MenumakerController) router.getController(Page.MENUMAKER)).updateMainPage();
        router.change(Page.MENUMAKER);
    }
}
