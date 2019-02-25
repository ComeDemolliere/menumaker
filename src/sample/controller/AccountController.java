package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Page;

public class AccountController extends Controller {

    @FXML
    private Button addProfile;

    @Override
    public void init(){
        super.init();
        //addProfile.setOnAction(actionEvent -> this.router.change(Page.ADDGUEST));
    }


}
