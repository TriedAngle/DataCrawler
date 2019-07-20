package net.strobl.management;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    private Manager manager;

    @Override
    public void start(Stage primaryStage) {
        manager = new Manager(this, primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }


}
