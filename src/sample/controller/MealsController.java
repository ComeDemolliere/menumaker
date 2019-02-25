package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Page;

public class MealsController extends Controller {

    @FXML
    private Button addGuest;

    @FXML
    private Button createReceipe;

    @Override
    public void init(){
        super.init();

        addGuest.setOnAction(actionEvent -> this.router.change(Page.ADDGUEST));
        createReceipe.setOnAction(actionEvent -> this.router.change(Page.DISHCREATION));
    }
}
