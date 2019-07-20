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

class GraphicsManager {
    private Stage stage;
    @FXML private StructureController structureController;
    @FXML private MainWindowController mainWindowController;

    GraphicsManager(Stage stage){
        this.stage = stage;

    }

    void displayMainWindow(){
        try {
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("/net/strobl/frontend/windows/MainWindow.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void displayHelloWorld(){
        stage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(event -> System.out.println("Hello World!"));

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }
}
