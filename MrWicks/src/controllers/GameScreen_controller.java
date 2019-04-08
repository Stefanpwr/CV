package controllers;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static main_files.Main.scheduler;

public class GameScreen_controller {

    private MainStackPane_controller mainStackPane_controller;

    //umozliwia zamkniecie dodawania podczas zamkniecia apki, do sprawdzenia czy
    //mozna zamknac wszystkie watki inną metodą
    public static ScheduledExecutorService adder = Executors.newScheduledThreadPool(3);

    //flaga zeby nie odpalac dodawania hajsu przy kazdym otworzeniu okna
    public static boolean adder_is_running = false;

    @FXML
    private Text kasa;
    @FXML
    private Text cigarettes_lvl;
    @FXML
    private Text cigars_lvl;
    @FXML
    private Text weeds_lvl;
    @FXML
    private Text electronics_lvl;
    @FXML
    private Text water_lvl;
    @FXML
    private Text supersonic_lvl;


    @FXML
    private Text cigarett_inc;
    @FXML
    private Text cigars_inc;
    @FXML
    private Text weeds_inc;
    @FXML
    private Text electronics_inc;
    @FXML
    private Text water_inc;
    @FXML
    private Text supersonic_inc;
    @FXML
    private Text income;

    @FXML
    private Label cigarette_information;

    @FXML
    private Label cigar_information;

    @FXML
    private Label water_pipes_information;

    @FXML
    private Label weed_information;

    @FXML
    private Label electronic_cigarettes_information;

    @FXML
    private Label supersonic_cigarettes_information;


    @FXML
    private Text cigarettes_cost;

    @FXML
    private Label cigarettes_cost_label;

    @FXML
    private Text cigar_cost;

    @FXML
    private Label cigar_cost_label;

    @FXML
    private Text water_pipes_cost;

    @FXML
    private Label water_pipes_cost_label;

    @FXML
    private Text weed_cost;

    @FXML
    private Label weed_cost_label;

    @FXML
    private Text supersonic_cigarettes_cost;

    @FXML
    private Label supersonic_cigarettes_cost_label;

    @FXML
    private Text electronic_cigarettes_cost;

    @FXML
    private Label electronic_cigarettes_cost_label;

    @FXML
    void initialize(){
        add_properties();
        setup_visibility_of_all_to_false();
        print_cash();
    }

    private void setup_visibility_of_all_to_false() {
        cigarette_information.setVisible(false);
        cigar_information.setVisible(false);
        weed_information.setVisible(false);
        water_pipes_information.setVisible(false);
        electronic_cigarettes_information.setVisible(false);
        supersonic_cigarettes_information.setVisible(false);
        cigarettes_cost.setVisible(false);
        cigarettes_cost_label.setVisible(false);
        cigar_cost.setVisible(false);
        cigar_cost_label.setVisible(false);
        weed_cost.setVisible(false);
        weed_cost_label.setVisible(false);
        supersonic_cigarettes_cost.setVisible(false);
        supersonic_cigarettes_cost_label.setVisible(false);
        electronic_cigarettes_cost.setVisible(false);
        electronic_cigarettes_cost_label.setVisible(false);
        water_pipes_cost.setVisible(false);
        water_pipes_cost_label.setVisible(false);
    }

    private void add_properties() {
        kasa.textProperty().bind(Bindings.format("%.2f",scheduler.player.cash));
        income.textProperty().bind(Bindings.format("%.2f",scheduler.player.income));

        cigarettes_lvl.textProperty().bind(Bindings.format("%d",scheduler.player.businesses.get(0).factory_lvlProperty()));
        cigars_lvl.textProperty().bind(Bindings.format("%d",scheduler.player.businesses.get(1).factory_lvlProperty()));
        water_lvl.textProperty().bind(Bindings.format("%d",scheduler.player.businesses.get(2).factory_lvlProperty()));
        weeds_lvl.textProperty().bind(Bindings.format("%d",scheduler.player.businesses.get(3).factory_lvlProperty()));
        electronics_lvl.textProperty().bind(Bindings.format("%d",scheduler.player.businesses.get(4).factory_lvlProperty()));
        supersonic_lvl.textProperty().bind(Bindings.format("%d",scheduler.player.businesses.get(5).factory_lvlProperty()));

        cigarettes_cost.textProperty().bind(Bindings.format("%.2f",scheduler.player.businesses.get(0).priceProperty()));
        cigar_cost.textProperty().bind(Bindings.format("%.2f",scheduler.player.businesses.get(1).priceProperty()));
        water_pipes_cost.textProperty().bind(Bindings.format("%.2f",scheduler.player.businesses.get(2).priceProperty()));
        weed_cost.textProperty().bind(Bindings.format("%.2f",scheduler.player.businesses.get(3).priceProperty()));
        electronic_cigarettes_cost.textProperty().bind(Bindings.format("%.2f",scheduler.player.businesses.get(4).priceProperty()));
        supersonic_cigarettes_cost.textProperty().bind(Bindings.format("%.2f",scheduler.player.businesses.get(5).priceProperty()));

        cigarett_inc.textProperty().bind(Bindings.format("%.2f",scheduler.player.businesses.get(0).incomeProperty()));
        cigars_inc.textProperty().bind(Bindings.format("%.2f",scheduler.player.businesses.get(1).incomeProperty()));
        water_inc.textProperty().bind(Bindings.format("%.2f",scheduler.player.businesses.get(2).incomeProperty()));
        weeds_inc.textProperty().bind(Bindings.format("%.2f",scheduler.player.businesses.get(3).incomeProperty()));
        electronics_inc.textProperty().bind(Bindings.format("%.2f",scheduler.player.businesses.get(4).incomeProperty()));
        supersonic_inc.textProperty().bind(Bindings.format("%.2f",scheduler.player.businesses.get(5).incomeProperty()));
    }

    @FXML
    public void back_to_menu(ActionEvent event){
        mainStackPane_controller.load_menu_screen();
    }

    @FXML
    void buy_Cigar(ActionEvent event) {
        scheduler.player.buy_shares("Cigar");
    }

    @FXML
    void buy_cigarettes(ActionEvent event) {
        scheduler.player.buy_shares("Cigarettes");
    }

    @FXML
    void buy_electronicCigarette(ActionEvent event) {
        scheduler.player.buy_shares("Electronic_Cigarettes");
    }

    @FXML
    void buy_superSonic(ActionEvent event) {
        scheduler.player.buy_shares("SuperSonic_Cigarettes");
    }

    @FXML
    void buy_waterPipes(ActionEvent event) {
        scheduler.player.buy_shares("Water_Pipes");
    }

    @FXML
    void buy_weed(ActionEvent event) {
        scheduler.player.buy_shares("Weed");
    }

    @FXML
    void sell(ActionEvent event) {

    }

    @FXML
    void upgrade(ActionEvent event) {

    }

    @FXML
    void cigarette_image_entered(){
        cigarette_information.setVisible(true);
    }

    @FXML
    void cigarette_image_released(){
        cigarette_information.setVisible(false);
    }

    @FXML
    void cigar_image_entered() {
        cigar_information.setVisible(true);
    }

    @FXML
    void cigar_image_released() {
        cigar_information.setVisible(false);
    }

    @FXML
    void electronic_cigarette_image_released() {
        electronic_cigarettes_information.setVisible(false);
    }

    @FXML
    void electronic_cigarettes_image_entered() {
        electronic_cigarettes_information.setVisible(true);
    }

    @FXML
    void supersonic_cigarettes_image_entered() {
        supersonic_cigarettes_information.setVisible(true);
    }

    @FXML
    void supersonic_cigarettes_image_released() {
        supersonic_cigarettes_information.setVisible(false);
    }

    @FXML
    void water_pipes_image_entered() {
        water_pipes_information.setVisible(true);
    }

    @FXML
    void water_pipes_image_released() {
        water_pipes_information.setVisible(false);
    }

    @FXML
    void weed_image_entered() {
        weed_information.setVisible(true);
    }

    @FXML
    void weed_image_released() {
        weed_information.setVisible(false);
    }

    @FXML
    void cigarettes_cost_entered(){
        cigarettes_cost.setVisible(true);
        cigarettes_cost_label.setVisible(true);
    }

    @FXML
    void cigarettes_cost_exited(){
        cigarettes_cost.setVisible(false);
        cigarettes_cost_label.setVisible(false);
    }

    @FXML
    void water_pipes_cost_entered() {
        water_pipes_cost.setVisible(true);
        water_pipes_cost_label.setVisible(true);
    }

    @FXML
    void water_pipes_cost_exited() {
        water_pipes_cost.setVisible(false);
        water_pipes_cost_label.setVisible(false);
    }

    @FXML
    void supersonic_cigarettes_cost_entered() {
        supersonic_cigarettes_cost.setVisible(true);
        supersonic_cigarettes_cost_label.setVisible(true);
    }

    @FXML
    void supersonic_cigarettes_cost_exited() {
        supersonic_cigarettes_cost.setVisible(false);
        supersonic_cigarettes_cost_label.setVisible(false);
    }

    @FXML
    void electronic_cigarettes_cost_entered() {
        electronic_cigarettes_cost.setVisible(true);
        electronic_cigarettes_cost_label.setVisible(true);
    }

    @FXML
    void electronic_cigarettes_cost_exited() {
        electronic_cigarettes_cost.setVisible(false);
        electronic_cigarettes_cost_label.setVisible(false);
    }

    @FXML
    void cigar_cost_entered() {
        cigar_cost.setVisible(true);
        cigar_cost_label.setVisible(true);
    }

    @FXML
    void cigar_cost_exited() {
        cigar_cost.setVisible(false);
        cigar_cost_label.setVisible(false);
    }

    @FXML
    void weed_cost_entered() {
        weed_cost.setVisible(true);
        weed_cost_label.setVisible(true);
    }

    @FXML
    void weed_cost_exited() {
        weed_cost.setVisible(false);
        weed_cost_label.setVisible(false);
    }

    public void print_cash(){
        Runnable print_cash = new Runnable(){
            public void run(){

                //wlasciwie to chyba nie ma potrzeby zeby ta metoda byla
                //"Runnable" , zwykla metoda chyba wystarczy
                scheduler.player.add_cash.run();
            }
        };
        if (!adder_is_running){ //sprawdza czy juz odpalone nie bylo zeby nie uruchamiac kilka razy
                                //nawet przy nowej grze zmieniaja sie dane wiec nie trzeba nic robic
            adder.scheduleAtFixedRate(print_cash,100,1000, TimeUnit.MILLISECONDS);
            adder_is_running = true;
        }
    }

    public void setMainStackPane_controller(MainStackPane_controller mainStackPane_controller) {
        this.mainStackPane_controller = mainStackPane_controller;
    }
}
