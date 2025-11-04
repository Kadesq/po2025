package symulator;

public class Samochod extends Silnik{
    private Silnik silnik = new Silnik("V12", 1, 1);
    private SkrzyniaBiegow skrzynia;

    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia) {
        this.silnik = silnik;
        this.skrzynia = skrzynia;
    }

    public void wlacz(){

    }

    public void wylacz(){

    }
}
