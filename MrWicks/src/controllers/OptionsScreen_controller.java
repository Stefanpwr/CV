package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class OptionsScreen_controller {

    private MainStackPane_controller mainStackPane_controller;

    @FXML
    public void back(){
        mainStackPane_controller.load_menu_screen();
    }

    public void setMainStackPane_controller(MainStackPane_controller mainStackPane_controller) {
        this.mainStackPane_controller = mainStackPane_controller;
    }
}
