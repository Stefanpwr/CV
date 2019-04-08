package main_files;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.*;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static controllers.GameScreen_controller.adder;

public class Main extends Application {
    //Scheduler scheduler = new Scheduler();
    //public boolean was_run
    // = false;

    public static Scheduler scheduler;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    //wczytywanie MainStackPane
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml_files/MainStackPane.fxml"));
        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gierka");
        primaryStage.show();
    }

    @Override
    public void stop(){
        System.out.print("The end!");
        adder.shutdown(); //wylaczenie dodawania kasy
        if(scheduler != null){ //sprawdza czy gra sie wgl uruchomila
            IOSystem ioSystem = new IOSystem();
            ioSystem.write(scheduler.player.toString()); //zapis
        }
    }


   /* public void start1(Stage primaryStage) {
        //Making Grids
        GridPane home_grid = new GridPane();
        GridPane gameplay_grid = new GridPane();
        gameplay_grid.setHgap(10);
        gameplay_grid.setVgap(10);
        gameplay_grid.setPadding(new Insets(8,8,8,8));


       //Showing main_files.Player cash
        Text cash  = new Text();
        cash.setLayoutX(100);
        cash.setLayoutY(200);
         Runnable print_cash = new Runnable(){
            public void run(){
               cash.setText(Double.toString(scheduler.player.cash));
            }
        };
        ScheduledExecutorService adder2 = Executors.newScheduledThreadPool(1);
        adder2.scheduleAtFixedRate(print_cash,0,2, TimeUnit.SECONDS);
        gameplay_grid.add(cash,20,30); //adding cash to Gameplay_Grid
        // end of Showing main_files.Player cash

        //Scene Home
        Scene home_scene = new Scene(home_grid, 600, 600);

        //Scene gameplay
        Scene gameplay = new Scene(gameplay_grid,600,600);

        //Making Return button
        Button back_to_home = new Button("Powrot do przeszlosci");
        gameplay_grid.add(back_to_home,5,5);
        EventHandler<ActionEvent> back = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {

                primaryStage.setTitle("Wyjebista Gierka Do kurwy nedzy");
                primaryStage.setScene(home_scene);
                primaryStage.show();

            }
        };
        back_to_home.setOnAction(back);
        //End of Return_Button

        //Button Start_Game and it's Event
        Button start_Game = new Button("Rozpocznij");
        home_grid.add(start_Game,20,20);
        EventHandler<ActionEvent> runGame = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (!was_run) {
                    scheduler.run();
                }
                primaryStage.setTitle("Mr.Wicks -");
                primaryStage.setScene(gameplay);
                primaryStage.show();
                was_run=true;
            }
        };
        start_Game.setOnAction(runGame);
        //End of StarT_Game Button

        //Button buy_Cigarettes and it's Event
        Button buy_Cigarettes = new Button("+");
        gameplay_grid.add(buy_Cigarettes,20,20);
        EventHandler<ActionEvent> buycigarettes = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scheduler.player.buy_shares("Cigarettes");
            }
        };
        buy_Cigarettes.setOnAction(buycigarettes);
        //End of buy_Cigarettes button

        //Starting The Game
        primaryStage.setTitle("Mr.Wicks -");
        primaryStage.setScene(home_scene);
        primaryStage.show();

    }
*/
}
