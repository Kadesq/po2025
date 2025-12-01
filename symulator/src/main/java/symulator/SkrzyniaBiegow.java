package symulator;

public class SkrzyniaBiegow extends Komponent{
    private int aktualnyBieg;
    private int iloscBiegow;
    private double aktualnePrzylozenie;

    public SkrzyniaBiegow(String nazwa, double cena, double waga, int iloscBiegow) {
        super(nazwa, cena, waga);
        this.aktualnyBieg = 0;
        this.iloscBiegow = 6;
    }

    public void zwiekszBieg(){
        if(aktualnyBieg<iloscBiegow){
            this.aktualnyBieg = aktualnyBieg + 1;
        }
        else{
            System.out.println("Maksymalny bieg");
        }
    }

    public void zmniejszBieg(){
        if(aktualnyBieg>0){
            this.aktualnyBieg = aktualnyBieg - 1;
        }
        else {
            System.out.println("Aktualnie jest Neutralny bieg");
        }
    }

    public void luz(){
        aktualnyBieg=0;
    }
}
