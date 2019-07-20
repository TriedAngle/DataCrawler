package net.strobl.management;

import javafx.stage.Stage;

public class Manager {
    private Stage stage;
    private DataManager dataManager;
    private GraphicsManager graphicsManager;

    Manager(App app, Stage stage){
        this.stage = stage;
        graphicsManager = new GraphicsManager(stage);
        graphicsManager.displayHelloWorld();
        graphicsManager.displayMainWindow();
        //dataManager = new DataManager("", "", "", "");

    }
}
