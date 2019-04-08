package main_files;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Business {

    private String name;
    private IntegerProperty factory_lvl;
    private DoubleProperty price;
    private DoubleProperty income;
    private double primary_income; //sluzy do pobrania podstawowego przychodu fabryki,
                                //wykorzystywane przy kupnie fabryki ktora miala 0 lvl,
                                //wtedy income=primary_income

    public Business(String name, int factory_lvl, double price, double primary_income, double income){
        this.name=name;
        this.factory_lvl = new SimpleIntegerProperty(this,"factory_lvlProperty",factory_lvl);
        this.price = new SimpleDoubleProperty(this,"priceProperty",price);
        this.income = new SimpleDoubleProperty(this,"incomeProperty",income);
        this.primary_income = primary_income;
    }

    public String get_name(){
        return name;
    }

     public int getFactory_lvl() {
         return factory_lvl.get();
     }

    public IntegerProperty factory_lvlProperty() {
        return factory_lvl;
    }

    public double getPrice() {
         return price.get();
     }

     public double getIncome() {
         return income.get();
     }

    public DoubleProperty incomeProperty() {
        return income;
    }

    public void setName(String name) {
         this.name = name;
     }

    public void setFactory_lvl(int factory_lvl) {
        this.factory_lvl.set(factory_lvl);
    }

    public void setPrice(double price) {
         this.price.set(price);
     }

    public void setIncome(double income) {
        this.income.set(income);
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    //pierwsze kupno
    public void first_buying(){
        income.set(primary_income);
    }

    @Override
    public String toString() {
        return name+" "+factory_lvl.get()+" "+price.get()+" "+primary_income+" "+income.get();
    }
}
