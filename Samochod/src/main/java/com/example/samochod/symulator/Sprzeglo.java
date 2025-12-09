package com.example.samochod.symulator;

public class Sprzeglo extends Komponent{
    boolean stanSprzegla;

    public Sprzeglo(String nazwa, double waga, double cena, boolean stanSprzegla) {
        super(nazwa, waga, cena);
        this.stanSprzegla=stanSprzegla;
    }

    public void wcisnij(){
        stanSprzegla=true;
    }

    public void zwolnij(){
        stanSprzegla=false;
    }

    public boolean getStanSprzegla() { return stanSprzegla; }
    public void setStanSprzegla(boolean stanSprzegla) {
        this.stanSprzegla = stanSprzegla;
    }
}
