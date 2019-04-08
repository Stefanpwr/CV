package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import main_files.IOSystem;
import main_files.Scheduler;

import java.io.IOException;
import java.util.Scanner;

import static main_files.Main.scheduler;

public class MenuScreen_controller {

    private MainStackPane_controller mainStackPane_controller;
    private static boolean game_was_started = false; //flaga pomagajaca ustalic czy sesja gry
                                                    //zostala rozpoczeta, aby nie ladowac
                                                    //poraz kolejny gry z pliku txt

    @FXML
    Label continue_error; //komunikat o bledzie kontynuacji gry

    @FXML
    void initialize(){
        continue_error.setVisible(false); //ustawienie na niewidoczny -> pokazuje sie tylko przy bledzie
    }

    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void options(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml_files/OptionsScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OptionsScreen_controller optionScreen_controller = loader.getController();
        optionScreen_controller.setMainStackPane_controller(mainStackPane_controller);
        mainStackPane_controller.setScreen(pane);
    }

    @FXML
    //pod przyciskiem "Rozpocznij nowa gre"
    void start_game(ActionEvent event) {

        scheduler = new Scheduler();
        game_was_started = true;

        load_GameScreen();
    }

    @FXML
    //pod przyciskiem "Kontynuuj"
    void continue_game(){
        if(game_was_started){
            load_GameScreen(); //jezeli gra zostala juz wczytana, albo rozpoczeto nowa gre, to tylko
                                //ladujemu GameScreen
        }
        else{
            IOSystem ioSystem = new IOSystem(); //stworzenie obiektu zapisu i odczytu
                                                //moglby byc w sumie jeden statyczny w Main jak Scheduler
            Scanner scanner = ioSystem.read();  //pobranie scannera czytajacego plik Save.txt
            if(scanner!=null){  //jesli wszystko dziala to wczytujemy gre
                scheduler = new Scheduler(scanner); //nowy scheduler ktory pobiera dane z Save.txt
                game_was_started = true;
                load_GameScreen();
            }
            else{ //jak blad to komunikat krotki na 3 sekundy, bez testu
                continue_error.setVisible(true);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue_error.setVisible(false);
            }
        }
    }

    private void load_GameScreen() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml_files/GameScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GameScreen_controller gameScreen_controller = loader.getController();
        gameScreen_controller.setMainStackPane_controller(mainStackPane_controller);
        mainStackPane_controller.setScreen(pane);
    }

    public void setMainStackPane_controller(MainStackPane_controller mainStackPane_controller) {
        this.mainStackPane_controller = mainStackPane_controller;
    }
}
