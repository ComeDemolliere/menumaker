package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.view.AccountSettings;
import sample.view.Fridge;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Router router = new Router(primaryStage);
        router.init();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
