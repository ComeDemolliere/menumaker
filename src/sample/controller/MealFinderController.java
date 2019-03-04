package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import sample.Page;
import sample.component.DishComponent;
import sample.component.IngredientComponent;

public class MealFinderController extends Controller {

    private DishComponent currentDish;

    @FXML
    private Button addMeal;

    @FXML
    private Text name;

    @FXML
    private TextArea receipe;

    @FXML
    private ListView<BorderPane> ingredients;

    @FXML
    private ImageView image;

    @Override
    public void init(){
        super.init();

        addMeal.setOnAction(actionEvent -> this.router.change(Page.FRIDGE));

        if(currentDish != null){
            image.setImage(new Image("sample/ressources/pictures/" + currentDish.getReceipe().getImage()));
            name.setText(currentDish.getReceipe().getName());
            receipe.setText(currentDish.getReceipe().getReceipe());
            currentDish.getReceipe().getIngredients().forEach(i -> {
                ingredients.getItems().add((new IngredientComponent(i)).getBorderPane());
            });
        }
    }

    public void setCurrentDish(DishComponent dish){
        this.currentDish = dish;
    }
}
