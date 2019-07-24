package net.strobl.frontend.windows;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class MainWindowController {
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
}
