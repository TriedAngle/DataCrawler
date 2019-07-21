package net.strobl.frontend.windows;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainWindowController {
    @FXML
    Label labelTest;
    @FXML
    Button buttonTest;

    public Label getLabelTest(){
        return labelTest;
    }

    public Button getButtonTest(){
        return buttonTest;
    }


}
