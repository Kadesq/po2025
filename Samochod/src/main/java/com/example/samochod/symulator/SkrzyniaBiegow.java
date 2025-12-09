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
        if(aktualnyBieg<iloscBiegow){
            aktualnyBieg++;
        }
        else{
            System.out.println("Maksymalny bieg");
        }
    }

    public void zmniejszBieg(){
        if(aktualnyBieg>0){
            aktualnyBieg--;
        }
        else {
            System.out.println("Aktualnie jest Neutralny bieg");
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
