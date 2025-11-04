package symulator;

public class Silnik extends Komponent {
    private double maxObroty;
    private double Obroty;

    public Silnik(String nazwa, double waga, double cena) {
        super(nazwa, waga, cena);
        this.maxObroty = 0;
        this.Obroty = 0;
    }

    public void uruchom() {
        this.Obroty = 800;
    }

    public void zatrzymaj(){
        this.Obroty = 0;
    }

    //public double zwiekszObroty() {}

    //public double zmniejszObroty() {}

}
