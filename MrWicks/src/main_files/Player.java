package main_files;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import main_files.Business;

import java.util.ArrayList;
import java.util.List;


public class Player {

    public DoubleProperty cash;
    public DoubleProperty income;
    private double charisma_lvl;
    private double management_lvl;
    public List<Business> businesses;

    public Player(){
        this.businesses = new ArrayList<>();
        this.cash = new SimpleDoubleProperty(this,"cashProperty",5.0);
        this.income = new SimpleDoubleProperty(this,"incomeProperty",0.0);
        this.charisma_lvl=1;
        this.management_lvl=1;
    }

    //konstruktor wykorzystywany przy odczycie z txt
    public Player(double charisma_lvl, double management_lvl, double cash, double income){
        this.businesses = new ArrayList<>();
        this.cash = new SimpleDoubleProperty(this,"cashProperty",cash);
        this.income = new SimpleDoubleProperty(this,"incomeProperty",income);
        this.charisma_lvl=charisma_lvl;
        this.management_lvl=management_lvl;
    }

    public boolean increase_charisma(){
        if(charisma_lvl<70) {
            if (cash.get() >= charisma_lvl * 100) {
                cash.set(cash.get() - charisma_lvl * 100);
                charisma_lvl++;
                return true;
            }
        }
        return false;
    }

    /**
     *  DO SPRAWDZENIA
     */
    public boolean increase_management(){
        if(cash.get()>=management_lvl*100){
            cash.set(cash.get() - management_lvl*100);
            management_lvl++;


            //dzielimy przez poprzedni mnoznik i mnozymy przez nowy
            income.set(income.get() * (1+(management_lvl/6.0))/(1+(management_lvl-1/6.0)));
            return true;
        }
        return false;
    }

    public void buy_shares(String name){
        for(Business business : businesses ){
            if(business.get_name().equals(name)) {
                double price_of_buy = (business.getPrice()-(business.getPrice()*(charisma_lvl/100)));
                if (cash.get() >= price_of_buy) {

                    cash.set(cash.get() - price_of_buy);

                    double previous_income = business.getIncome();

                    if(business.getFactory_lvl()>0){ //jezeli lvl>0 to znaczy ze jest
                                                    // income>0 , wiec mozna zwiekszyc
                        business.setIncome((business.getIncome() * 1.05) );
                    }
                    else{
                        business.first_buying(); //w przzeciwnym razie ustawiamy pierwszy income
                    }

                    business.setFactory_lvl(business.getFactory_lvl() + 1);
                    business.setPrice((business.getPrice()*1.3) );


                    //od razu ustawiamy income na realny uwzgledniajacy management_lvl, aby
                    //korzystac z bindowania
                    income.set(income.get() + (business.getIncome()-previous_income)*(1+(management_lvl/6.0)));
                    //zwiekszenie management_lvl w czasie gry jest wstepnie uwzglednione, bez testu
                }
            }
        }
    }

    public boolean sell_shares(){
        return true;
    }

    public Runnable add_cash = new Runnable(){
        public void run(){
            //income uwzglednia juz wszystkie fabryki i management_lvl, wystarczy dodawac
            cash.set(cash.get() + income.get());
        }
    };

    public String toString(){
        String communique = charisma_lvl+" "+management_lvl+" "+cash.get()+" "+income.get()+"\n";
        for (Business business: businesses) {
            communique+=business.toString();
            communique+="\n";
        }
        return communique;
    }
}
