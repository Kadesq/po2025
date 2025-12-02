package symulator;

public class Samochod {
    private Silnik silnik = new Silnik("V12", 1, 1);
    private SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("Automat", 1, 1, 6);

    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia) {
        this.silnik = silnik;
        this.skrzynia = skrzynia;
    }

    public void wlacz(){
        silnik.uruchom();
    }

    public void wylacz(){
    silnik.zatrzymaj();
    skrzynia.luz();
    }

    public static void main(String[] args){
        Silnik silnikSamochodu = new Silnik("V12", 1.0, 1.0);
        SkrzyniaBiegow skrzyniaSamochodu = new SkrzyniaBiegow("Automat", 1.0, 1.0, 6);
        Samochod samochod = new Samochod(silnikSamochodu, skrzyniaSamochodu);
        samochod.wlacz();
        samochod.skrzynia.zwiekszBieg();
        samochod.silnik.zwiekszObroty();
        samochod.silnik.zwiekszObroty();
        samochod.silnik.zwiekszObroty();
        samochod.silnik.zwiekszObroty();
        samochod.skrzynia.zwiekszBieg();
        samochod.wylacz();
    }
}
