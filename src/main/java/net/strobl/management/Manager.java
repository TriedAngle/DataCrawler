package net.strobl.management;

import javafx.stage.Stage;

public class Manager {
    private Stage stage;
    private DataManager dataManager;
    private GraphicsManager graphicsManager;

    Manager(App app, Stage stage){
        this.stage = stage;
        graphicsManager = new GraphicsManager(this, stage);
        graphicsManager.setup();
        dataManager = new DataManager();
    }

    void connectToDatabase(){
        dataManager.connect();
    }

    void setCredentials(String databaseType, String address, String username, String password, String table){
        dataManager.setDatabaseType(databaseType);
        dataManager.setCredentials(address, username, password, table);
    }

    boolean isConnected(){
        return dataManager.isConnected();
    }

    DataManager getDataManager(){
        return dataManager;
    }
}
