package com.example.samochod.symulator;

public class SkrzyniaBiegow extends Komponent{
    private int aktualnyBieg;
    private int iloscBiegow;
    private Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String nazwa, double waga, double cena, int iloscBiegow) {
        super(nazwa, waga, cena);
        this.sprzeglo = new Sprzeglo("Basic", 200, 1000,true);
        this.iloscBiegow = iloscBiegow;
    }

    public void zwiekszBieg(){
        if(this.sprzeglo.getStanSprzegla()){
            if(aktualnyBieg<iloscBiegow){
                aktualnyBieg++;
                System.out.println("Zwiększono bieg na: " + aktualnyBieg);
            }
            else{
                System.out.println("Maksymalny bieg");
            }
        }else {
            System.out.println("Wrrgrrzmrrr Nie wciśnięto sprzęgła.");
        }

    }

    public void zmniejszBieg(){
        if(this.sprzeglo.getStanSprzegla()){
            if(aktualnyBieg>0){
                aktualnyBieg--;
                System.out.println("Zmniejszono bieg na: " + aktualnyBieg);
            }
            else {
                System.out.println("Aktualnie jest Neutralny bieg");
            }
        }else {
            System.out.println("Wrrgrrzmrrr Nie wciśnięto sprzęgła.");
        }

    }

    public void luz(){
        aktualnyBieg=0;
    }

    public int getAktualnyBieg() {return aktualnyBieg;}
    public int getIloscBiegow() {return iloscBiegow;}
    public Sprzeglo getSprzeglo() {return sprzeglo;}

    public void setIloscBiegow(int iloscBiegow) {
        this.iloscBiegow = iloscBiegow;
    }
}
