package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
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
    private ListView<Profile> profiles;

    @Override
    public void init(){
        super.init();
        addProfile.setOnAction(action -> this.router.change(Page.ADDPROFILE));

        this.profiles.setItems(FXCollections.observableArrayList(profilesList));
        //addProfile.setOnAction(actionEvent -> this.router.change(Page.ADDGUEST));
    }

    public void addProfile(Profile profile) {
        this.profilesList.add(profile);
        ObservableList<Profile> bo = FXCollections.observableArrayList(profilesList);
        this.profiles.setItems(bo);
        //this.profiles.getItems().add(profile.getName());
    }

}
