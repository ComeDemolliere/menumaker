package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import sample.view.View;

import java.io.IOException;
import java.util.HashMap;

public class Router {

    private HashMap<String, Controller> controllerRoutes;
    private FXMLLoader loader;
    private HashMap<String, View> viewRoutes;


    private Stage main;


    public Router(Stage main) throws IOException {
        this.loader = new FXMLLoader();
        controllerRoutes = new HashMap<>();
        viewRoutes = new HashMap<>();
        this.main = main;

    }

    public void addRoute(String route, Controller controller, View view) {
        this.controllerRoutes.put(route, controller);
        this.viewRoutes.put(route, view);
        controller.setRouter(this);
    }


    public void change(String route) throws IOException {

        Controller currentController = controllerRoutes.get(route);
        View view = viewRoutes.get(route);
        System.out.println(view.getLABEL() + "" + view.getClass());

        loader.setController(currentController);

        Parent parent = loader.load(getClass().getResource(view.getXML_FILE()));


        currentController.init();

        this.main.setScene(new Scene(parent, view.getWIDTH(), view.getHEIGHT()));
        this.main.show();
    }


}
