package main_files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOSystem {

    public void write(String communique){
        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter("Save.txt");
            zapis.println(communique);
            zapis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Scanner read(){
        File file = new File("Save.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND !!!");
            e.printStackTrace();
        }
        return scanner;
    }
}
