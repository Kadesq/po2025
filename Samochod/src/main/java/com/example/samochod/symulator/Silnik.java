package com.example.samochod.symulator;

public class Silnik extends Komponent {
    private int maxObroty;
    private int Obroty;

    public Silnik(String nazwa, double waga, double cena, int maxObroty) {
        super(nazwa, waga, cena);
        this.maxObroty = maxObroty;
        this.Obroty = 0;
    }

    public void uruchom() {
        this.Obroty = 800;
    }

    public void zatrzymaj(){
        this.Obroty = 0;
    }

    public void zwiekszObroty() {
       if (this.Obroty < this.maxObroty) {this.Obroty += 200;}
    }

    public void zmniejszObroty() {
        if (this.Obroty > this.maxObroty) {this.Obroty -= 200;}
    }

    public int getMaxObroty() {
        return maxObroty;
    }

    public int getObroty() {
        return Obroty;
    }

    public void setMaxObroty(int maxObroty) {this.maxObroty = maxObroty;}

}
