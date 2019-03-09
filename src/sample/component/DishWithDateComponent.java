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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        loadStyle();
    }

    private void loadStyle(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date today = null;
        Date receipeDate = null;
        try {
            today = sdf.parse(sdf.format(date));
            receipeDate = sdf.parse(receipe.getDate());
        } catch (ParseException e) { e.printStackTrace(); }

        int comparator = today.compareTo(receipeDate);
        if(comparator == 0) dish.setStyle("-fx-background-color: #BEF781");
        else if (comparator > 0) dish.setStyle("-fx-background-color: #E6E6E6");
        else dish.setStyle("-fx-background-color: #F3F781");
    }

    @Override
    public BorderPane getBorderPane() {
        return this.dish;
    }

    public Receipe getReceipe(){
        return this.receipe;
    }
}
