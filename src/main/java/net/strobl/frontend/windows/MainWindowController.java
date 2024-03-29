package net.strobl.frontend.windows;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    Label labelAddress;
    @FXML
    Label labelUsername;
    @FXML
    Label labelPassword;
    @FXML
    Label labelTable;

    @FXML
    Button buttonConnect;
    @FXML
    Button buttonDownload;
    @FXML
    Circle circleConnected;
    @FXML
    TextField textAddress;
    @FXML
    TextField textUsername;
    @FXML
    TextField textPassword;
    @FXML
    TextField textTable;

    public void setCircleColor(boolean connected) {
        if(connected){
            circleConnected.setFill(Color.GREEN);
        }else {
            circleConnected.setFill(Color.RED);
        }
    }

    public Button getButtonConnect() {
        return buttonConnect;
    }

    public void setButtonConnect(Button buttonConnect) {
        this.buttonConnect = buttonConnect;
    }

    public Button getButtonDownload() {
        return buttonDownload;
    }

    public void setButtonDownload(Button buttonDownload) {
        this.buttonDownload = buttonDownload;
    }

    public Circle getCircleConnected() {
        return circleConnected;
    }

    public void setCircleConnected(Circle circleConnected) {
        this.circleConnected = circleConnected;
    }

    public TextField getTextAddress() {
        return textAddress;
    }

    public void setTextAddress(TextField textAddress) {
        this.textAddress = textAddress;
    }

    public TextField getTextUsername() {
        return textUsername;
    }

    public void setTextUsername(TextField textUsername) {
        this.textUsername = textUsername;
    }

    public TextField getTextPassword() {
        return textPassword;
    }

    public void setTextPassword(TextField textPassword) {
        this.textPassword = textPassword;
    }

    public TextField getTextTable() {
        return textTable;
    }

    public void setTextTable(TextField textTable) {
        this.textTable = textTable;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        circleConnected.setFill(Color.GRAY);
    }
}
