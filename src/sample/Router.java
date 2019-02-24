package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import sample.controller.*;
import sample.view.*;

import java.io.IOException;
import java.util.HashMap;

public class Router {

    private HashMap<Page, Controller> controllerRoutes;
    private FXMLLoader loader;
    private HashMap<Page, View> viewRoutes;


    private Stage main;


    public Router(Stage main) throws IOException {
        controllerRoutes = new HashMap<>();
        viewRoutes = new HashMap<>();
        this.main = main;

    }

    public void init(){
        //init route
        addRoute(Page.MENUMAKER, new MenumakerController(), new Menumaker());
        addRoute(Page.FRIDGE, new FridgeController(), new Fridge());
        addRoute(Page.MEALS, new MealsController(), new Meals());
        addRoute(Page.MEALFINDER, new MealFinderController(), new MealFinder());
        /*
        addRoute(Page.DISHCREATION, new Controller(), new DishCreation());
        addRoute(Page.ADDGUEST, new Controller(), new AddGuest());
        addRoute(Page.ACCOUNT, new Controller(), new AccountSettings());*/

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
        System.out.println(view.getLABEL() + " " + view.getClass());

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


}
