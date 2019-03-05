package sample.component;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import models.Receipe;
import sample.view.DishView;
import sample.view.DishWithDateView;

import java.util.ArrayList;
import java.util.List;

public class DishWithDateComponent extends Component {

    private Receipe receipe;

    @FXML
    private BorderPane dish;

    @FXML
    private ImageView image;

    @FXML
    private Text title;

    @FXML
    private Text date;

    public DishWithDateComponent(Receipe receipe){
        this.load(new DishWithDateView());
        this.receipe = receipe;

        this.date.setText(receipe.getDate());
        this.image.setImage(new Image("sample/ressources/pictures/" + receipe.getImage()));
        this.title.setText(receipe.getName());
    }

    @Override
    public BorderPane getBorderPane() {
        return this.dish;
    }

    public Receipe getReceipe(){
        return this.receipe;
    }
}
