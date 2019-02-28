package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
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
    private Text receipeText;

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
        ((MenumakerController) router.getController(Page.MENUMAKER)).addDish(new DishComponent(receipe));
        router.change(Page.MENUMAKER);
    }
}