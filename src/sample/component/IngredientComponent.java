package sample.component;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import models.Ingredient;
import sample.view.IngredientView;

public class IngredientComponent extends Component {

    private Ingredient ingredient;

    @FXML
    private BorderPane ingredientPanel;

    @FXML
    private Text name;

    @FXML
    private Text quantity;

    public IngredientComponent(Ingredient ingredient){
        this.load(new IngredientView());

        this.name.setText(ingredient.getTitle());
        this.quantity.setText("" + ingredient.getAmount());
    }

    public BorderPane getIngredient(){
        return this.ingredientPanel;
    }
}
