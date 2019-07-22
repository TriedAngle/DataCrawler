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

    Random rand = new Random();

    GraphicsManager(Manager manager, Stage stage) {
        this.manager = manager;
        this.stage = stage;
    }

    void setup(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/net/strobl/frontend/general/Structure.fxml"));
            Parent root = loader.load();
            structureController = loader.getController();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void displayMainWindow() {
        try {
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/net/strobl/frontend/windows/MainWindow.fxml"));
            Parent root = loader.load();
            mainWindowController = loader.getController();

            mainWindowController.getButtonTest().setOnAction(event -> {
                        clicked();
                        mainWindowController.getLabelTest().setText(String.valueOf(rand.nextInt(50)));
                        displayHelloWorld();
                    }
            );
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void clicked() {
        System.out.println("clicked");
    }

    void displayHelloWorld() {
        Stage sStage = new Stage();
        sStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(event -> {
            System.out.println("Hello World!");
            mainWindowController.getLabelTest().setText("Hello world Pressed");
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        sStage.setScene(new Scene(root, 300, 250));
        sStage.show();
    }
}
