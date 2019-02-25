package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Page;

public class AddGuestController extends Controller{

    @FXML
    private Button save;

    @Override
    public void init(){
        super.init() ;
        save.setOnAction(actionEvent -> this.router.change(Page.MEALS));
    }
}
