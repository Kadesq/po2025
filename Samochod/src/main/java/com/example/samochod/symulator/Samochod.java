package com.example.samochod.symulator;

public class Samochod {
    private String model;
    private String nrRejestracyjny;

    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;

    public Samochod(String model, String nrRejestracyjny) {
        this.model = model;
        this.nrRejestracyjny = nrRejestracyjny;

        this.silnik = new Silnik("V8", 300, 50000, 7000);
        this.skrzynia = new SkrzyniaBiegow("Manual 6", 80, 5000, 6);
    }

    public void wlacz(){
        silnik.uruchom();
    }

    public void wylacz(){
    silnik.zatrzymaj();
    skrzynia.luz();
    }

    public Silnik getSilnik() {return silnik;}
    public String getModel() {return model;}
    public double getWaga() {return (silnik.getWaga() + skrzynia.getWaga() + skrzynia.getSprzeglo().getWaga());}
    public SkrzyniaBiegow getSkrzynia() {return skrzynia;}
    public String getNrRejestracyjny() {return  nrRejestracyjny;}


    @Override
    public String toString() {
        return model + "(" + nrRejestracyjny + ")";
    }
}
