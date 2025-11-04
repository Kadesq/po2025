package symulator;

public class Pozycja {
    double x;
    double y;

    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void nowaPozycja(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    public String getPozycja() {
        return "x: " + x + " y: " + y;
    }
}
