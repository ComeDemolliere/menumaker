package sample.component;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import models.Ingredient;
import models.Receipe;
import sample.view.DishView;
import sample.view.View;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DishComponent extends Component{

    private List<IngredientComponent> ingredientComponentList;

    @FXML
    private BorderPane dish;

    @FXML
    private ImageView image;

    @FXML
    private Text title;

    @FXML
    private ListView<BorderPane> ingredients;

    public DishComponent(Receipe receipe){
        this.load(new DishView());

        this.ingredientComponentList = new ArrayList<>();

        receipe.getIngredients().forEach(i -> ingredientComponentList.add(new IngredientComponent(i)));

        System.out.println("sample/ressources/pictures/" + receipe.getImage());
        this.image.setImage(new Image("sample/ressources/pictures/" + receipe.getImage()));
        this.title.setText(receipe.getName());
        this.ingredientComponentList.forEach(i -> this.ingredients.getItems().add(i.getIngredient()));
    }

    public BorderPane getDish(){
        return this.dish;
    }
}
