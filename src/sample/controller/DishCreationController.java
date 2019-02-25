package sample.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Page;
import sample.view.DishCreation;

public class DishCreationController extends Controller{

    public DishCreationController(){

    }

    @FXML
    private Button createDish;
    
    @Override
    public void init(){
        super.init();
        createDish.setOnAction(actionEvent -> this.router.change(Page.MEALS));
    }
}
