import java.util.*;

public class Main {
    public static void main(String[] args){
        Random rand = new Random();

        ArrayList<Integer> lottoNumbers = new ArrayList<>();

        while(lottoNumbers.size() < 6){
            int number = rand.nextInt(49)+1;
            lottoNumbers.add(number);
        }

        System.out.println("Wynik: " + lottoNumbers);
    }
}