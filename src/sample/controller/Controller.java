package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import sample.Router;
import sample.Page;

public abstract class Controller {

    protected Router router;

    @FXML
    private Button fridge;

    @FXML
    private Button menumaker;

    @FXML
    private Button meals;

    @FXML
    private ImageView user;


    public void setRouter(Router router){
        this.router = router;
    }

    public void init(){
       fridge.setOnAction(actionEvent -> this.router.change(Page.FRIDGE));
       menumaker.setOnAction(actionEvent -> this.router.change(Page.MENUMAKER));
       meals.setOnAction(actionEvent -> this.router.change(Page.MEALS));
       user.setOnMouseClicked(event -> this.router.change(Page.ACCOUNT));
    }
}
