package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import javafx.application.Application;
import javafx.stage.Stage;
import models.Receipe;
import sample.view.AccountSettings;
import sample.view.Fridge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Router router = new Router(primaryStage);
        router.init();
    }


    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        JsonReader reader = new JsonReader(new FileReader("/home/arconec/Documents/S6/menumaker/src/sample/test.json"));

        Receipe receipe = gson.fromJson(reader, Receipe.class);


    }
}
