package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import models.Dishes;
import models.Ingredient;
import models.Receipe;
import sample.controller.*;
import sample.view.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Router {

    private HashMap<Page, Controller> controllerRoutes;
    private FXMLLoader loader;
    private HashMap<Page, View> viewRoutes;

    private Dishes dishes;
    private List<Ingredient> ingredients;

    private Stage main;


    public Router(Stage main) throws IOException {
        controllerRoutes = new HashMap<>();
        viewRoutes = new HashMap<>();
        this.main = main;

    }

    public void init(){
        //load json
        this.loadJson();

        //init route
        addRoute(Page.MENUMAKER, new MenumakerController(dishes.getReceipes()), new Menumaker());
        addRoute(Page.FRIDGE, new FridgeController(ingredients), new Fridge());
        addRoute(Page.MEALS, new MealsController(dishes.getReceipes()), new Meals());
        addRoute(Page.MEALFINDER, new MealFinderController(), new MealFinder());
        addRoute(Page.ACCOUNT, new AccountController(), new AccountSettings());
        addRoute(Page.DISHCREATION, new DishCreationController(), new DishCreation());
        addRoute(Page.ADDGUEST, new AddGuestController(), new AddGuest() );
        addRoute(Page.DISHVALIDATION, new DishValidationController(), new DishValidationView());
        addRoute(Page.ADDPROFILE, new CreateProfileController(), new CreateProfile());
        //load principal page
        change(Page.MENUMAKER);
    }

    public void addRoute(Page route, Controller controller, View view) {
        this.controllerRoutes.put(route, controller);
        this.viewRoutes.put(route, view);
        controller.setRouter(this);
    }


    public void change(Page route){
        this.loader = new FXMLLoader();

        Controller currentController = controllerRoutes.get(route);
        View view = viewRoutes.get(route);
        loader.setController(currentController);

        Parent parent = null;
        try {
            parent = loader.load(getClass().getResourceAsStream(view.getXML_FILE()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        currentController.init();

        this.main.setScene(new Scene(parent, view.getWIDTH(), view.getHEIGHT()));
        this.main.show();
    }

    private void loadJson(){

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        JsonReader readerDishes = null;
        JsonReader readerFridge = null;
        try {
            readerDishes = new JsonReader(new FileReader("src/sample/ressources/json/receipes.json"));
            readerFridge = new JsonReader(new FileReader("src/sample/ressources/json/initialFridge.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(readerDishes != null)
            this.dishes = gson.fromJson(readerDishes, Dishes.class);
        if(readerFridge != null){
            Receipe receipe = gson.fromJson(readerFridge, Receipe.class);
            this.ingredients = receipe.getIngredients();
        }
    }

    public Controller getController(Page page){
        return controllerRoutes.get(page);
    }

}
