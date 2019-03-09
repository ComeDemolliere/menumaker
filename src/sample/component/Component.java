package sample.component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import sample.view.View;

import java.io.IOException;

public abstract class Component {

    public void load(View view){
        FXMLLoader loader = new FXMLLoader();

        loader.setController(this);
        Parent parent = null;
        try {
            parent = loader.load(getClass().getResourceAsStream("../" + view.getXML_FILE()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract BorderPane getBorderPane();
}
