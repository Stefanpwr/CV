package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import main_files.Scheduler;

import java.io.IOException;

public class MainStackPane_controller {

    //public static Scheduler scheduler = new Scheduler();

    @FXML
    private StackPane main_stack_pane;

    @FXML
    void initialize(){
        load_menu_screen();
    }

    //ladowanie MenuScreen
    public void load_menu_screen() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml_files/MenuScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuScreen_controller menuScreen_controller = loader.getController();
        menuScreen_controller.setMainStackPane_controller(this);
        setScreen(pane);
    }

    public void setScreen(Pane pane) {
        main_stack_pane.getChildren().clear();
        main_stack_pane.getChildren().add(pane);
    }
}
