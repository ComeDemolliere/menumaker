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
import models.Ingredient;
import sample.view.DishView;
import sample.view.View;

import javax.xml.soap.Text;
import java.io.IOException;
import java.util.List;

public class DishComponent extends Node {

    @FXML
    private BorderPane dish;

    @FXML
    private ImageView image;

    @FXML
    private Text title;

    @FXML
    private ListView<Ingredient> ingredients;

    public BorderPane getDish(){
        return this.dish;
    }

    public void setDish( String title, List<Ingredient> ingredients){
        //this.image.setImage(image);
        this.title.setValue(title);
        this.ingredients.getItems().addAll(ingredients);
    }

    public void load(){
        FXMLLoader loader = new FXMLLoader();

        View view = new DishView();

        loader.setController(this);
        Parent parent = null;
        try {
            parent = loader.load(getClass().getResourceAsStream("../" + view.getXML_FILE()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(parent);
    }

    @Override
    protected NGNode impl_createPeer() {
        return null;
    }

    @Override
    public BaseBounds impl_computeGeomBounds(BaseBounds baseBounds, BaseTransform baseTransform) {
        return null;
    }

    @Override
    protected boolean impl_computeContains(double v, double v1) {
        return false;
    }

    @Override
    public Object impl_processMXNode(MXNodeAlgorithm mxNodeAlgorithm, MXNodeAlgorithmContext mxNodeAlgorithmContext) {
        return null;
    }
}
