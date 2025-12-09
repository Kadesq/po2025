package com.example.samochod.symulator;

public class Pozycja {
    private double x;
    private double y;

    public Pozycja() {
        this(0,0);
    }

    public Pozycja(double x) {
        this(x,0);
    }
    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }
    void nowaPozycja(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    public String getPozycja() {
        return "x: " + this.x + " y: " + this.y;
    }
}
