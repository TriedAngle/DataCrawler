package net.strobl.management;

import javafx.stage.Stage;

public class Manager {
    private Stage stage;

    Manager(App app, Stage stage){
        this.stage = stage;
        new DataManager("", "", "", "");
    }
}
