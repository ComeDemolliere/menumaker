package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.view.AccountSettings;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Router router = new Router(primaryStage);
        router.addRoute("test", new Controller(), new AccountSettings());

        router.change("test");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
