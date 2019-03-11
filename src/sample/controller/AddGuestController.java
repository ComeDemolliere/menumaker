package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import models.Profile;
import sample.Page;

import java.util.ArrayList;
import java.util.List;

public class AddGuestController extends Controller{

    private List<Profile> profileList;
    private List<Profile> guestList;

    @FXML
    private Button save;

    @FXML
    private ListView<Profile> profiles;

    @FXML
    private ListView<Profile> guests;

    @FXML
    private Button addGuest;

    @FXML
    private Button rmGuest;

    public AddGuestController(){
        profileList = new ArrayList<>();
        guestList = new ArrayList<>();
    }

    @Override
    public void init(){
        super.init();
        save.setOnAction(actionEvent -> this.router.change(Page.MEALS));
        addGuest.setOnAction(actionEvent -> addGuest());
        rmGuest.setOnAction(actionEvent -> removeGuest());

        ObservableList<Profile> p = FXCollections.observableArrayList(profileList);
        ObservableList<Profile> g = FXCollections.observableArrayList(guestList);
        this.profiles.setItems(p);
        this.guests.setItems(g);
    }

    public void addProfiles(Profile profile){
        this.profileList.add(profile);
    }

    private void addGuest(){
        int index = this.profiles.getSelectionModel().getSelectedIndex();
        if (index >= 0 ){
            guestList.add(profileList.get(index));
            profileList.remove(index);
        }
        this.init();
    }

    private void removeGuest(){
        int index = this.guests.getSelectionModel().getSelectedIndex();
        if (index >= 0 ){
            profileList.add(guestList.get(index));
            guestList.remove(index);
        }
        this.init();
    }
}
