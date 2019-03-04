package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import models.Profile;
import sample.Page;

import java.util.ArrayList;
import java.util.List;

public class AccountController extends Controller {

    private List<Profile> profilesList = new ArrayList<>();
    @FXML
    private Button addProfile;

    @FXML
    private ListView<Text> profiles;
    @Override
    public void init(){
        super.init();
        addProfile.setOnAction(action -> this.router.change(Page.ADDPROFILE));
        //addProfile.setOnAction(actionEvent -> this.router.change(Page.ADDGUEST));
    }

    public void addProfile(Profile profile) {
        this.profilesList.add(profile);
        this.profiles.getItems().add(new Text("Salut" + profile.getName()));
        System.out.println(profiles.getItems());
    }

}
