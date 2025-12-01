package symulator;

public class Silnik extends Komponent {
    private int maxObroty;
    private int Obroty;

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

    public void zwiekszObroty() {
        this.Obroty += 200;
    }

    public void zmniejszObroty() {
        this.Obroty -= 200;
    }

    public int getMaxObroty() {
        return maxObroty;
    }

    public int getObroty() {
        return Obroty;
    }

}
