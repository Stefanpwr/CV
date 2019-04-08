package main_files;

import main_files.Business;
import main_files.Player;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {

    public Player player;

    //podstawowy scheduler do nowej gry
    public Scheduler(){
        this.player = new Player();
        this.run();
    }

    //scheduler do wczytanej gry
    public Scheduler(Scanner scanner){
        //player pobierajacy dane z txt
        this.player = new Player(Double.parseDouble(scanner.next()),Double.parseDouble(scanner.next()),Double.parseDouble(scanner.next()),Double.parseDouble(scanner.next()));
        //Double.parseDouble(scanner.next()) -> pierwszy pomysl na rozwiazanie problemu ','  i  '.'
        //przy odczytywaniu i zapisywaniu double
        this.run(scanner); //przeciazona metoda tworzenia listy fabryk
    }

    public void run(){
        Business Cigarettes = new Business("Cigarettes", 0, 5, 2,0);
        player.businesses.add(Cigarettes);
        Business Cigar = new Business("Cigar", 0, 150, 10,0);
        player.businesses.add(Cigar);
        Business Water_Pipes = new Business("Water_Pipes", 0, 4500, 40,0);
        player.businesses.add(Water_Pipes);
        Business Weed = new Business("Weed", 0, 15000, 100,0);
        player.businesses.add(Weed);
        Business Electronic_Cigarette = new Business("Electronic_Cigarettes", 0, 60000, 400,0);
        player.businesses.add(Electronic_Cigarette);
        Business SuperSonic_Cigarettes = new Business("SuperSonic_Cigarettes", 0, 1000000, 800,0);
        player.businesses.add(SuperSonic_Cigarettes);
    }



    //pobiera dane z txt, chyba mozna ulepszyc poprzez petle
    public void run(Scanner scanner){
        Business Cigarettes = new Business(scanner.next(), scanner.nextInt(), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()),Double.parseDouble(scanner.next()));
        player.businesses.add(Cigarettes);
        Business Cigar = new Business(scanner.next(), scanner.nextInt(), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()),Double.parseDouble(scanner.next()));
        player.businesses.add(Cigar);
        Business Water_Pipes = new Business(scanner.next(), scanner.nextInt(), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
        player.businesses.add(Water_Pipes);
        Business Weed = new Business(scanner.next(), scanner.nextInt(), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
        player.businesses.add(Weed);
        Business Electronic_Cigarette = new Business(scanner.next(), scanner.nextInt(), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
        player.businesses.add(Electronic_Cigarette);
        Business SuperSonic_Cigarettes = new Business(scanner.next(), scanner.nextInt(), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
        player.businesses.add(SuperSonic_Cigarettes);
    }
}
