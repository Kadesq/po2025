package zadania;

import animals.*;
import java.util.*;

public class Zoo {
    Animal[] animals =  new Animal[100];

    public Zoo(){
        fillTheZoo();
        legsSum();
    }

    public void fillTheZoo() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int random = rand.nextInt(3);

            switch (random){
                case 0:
                    animals[i] = new Snake("Snake");
                    break;
                case 1:
                    animals[i] = new Dog("Dog");
                    break;
                case 2:
                    animals[i] = new Parrot("Parrot");
                    break;
            }
            animals[i].getDescription();
            int legs = animals[i].getLegs()*2;
        }
    }

    public int legsSum() {
        int sum = 0;
        for (Animal animal : animals) {
            sum += animal.getLegs();
        }
        System.out.println("Suma nog: " + sum);
        return sum;
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
    }
}
