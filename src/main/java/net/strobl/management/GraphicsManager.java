package net.strobl.management;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import net.strobl.frontend.general.StructureController;
import net.strobl.frontend.windows.MainWindowController;

import java.io.IOException;
import java.util.Random;

class GraphicsManager {
    private Manager manager;
    private Stage stage;
    @FXML
    private StructureController structureController;
    @FXML
    private MainWindowController mainWindowController;

    GraphicsManager(Manager manager, Stage stage) {
        this.manager = manager;
        this.stage = stage;
    }

    void setup() {
        try {
            FXMLLoader loader = loadFX("frontend/windows/MainWindow.fxml");
            Parent root = loader.load();
            mainWindowController = loader.getController();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            addActions();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addActions() {
        // Full EKS DEE MODE
//        stage.setOnCloseRequest(event -> {
//            stage = new Stage();
//            setup();
//        });

        // Connect Button
        mainWindowController.getButtonConnect().setOnAction(event -> {
            String address = mainWindowController.getTextAddress().getText();
            String username = mainWindowController.getTextUsername().getText();
            String password = mainWindowController.getTextPassword().getText();
            String table = mainWindowController.getTextTable().getText();
            manager.getDataManager().setCredentials(address, username, password, table);
            manager.connectToDatabase();
            mainWindowController.setCircleColor(manager.isConnected());
        });

        // Download Button
        mainWindowController.getButtonDownload().setOnAction(event -> {
            manager.getDataManager().readAllBills();
            manager.getDataManager().readColumnNames();
            manager.getFileManager().setData(manager.getDataManager().getBills(), manager.getDataManager().getColumnNames());
            manager.getFileManager().writeData();
        });
    }

    private FXMLLoader loadFX(String path) {
        return new FXMLLoader(getClass().getResource("/net/strobl/" + path));
    }

    private void clicked() {
        System.out.println("clicked");
    }

    @Deprecated
    void displayHelloWorld() {
        Stage sStage = new Stage();
        sStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(event -> clicked());
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        sStage.setScene(new Scene(root, 300, 250));
        sStage.show();
    }
}
