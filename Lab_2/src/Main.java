import java.util.*;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> myNumbers = new ArrayList<>();
        for (String arg : args) {
            int myNumber = Integer.parseInt(arg);
            myNumbers.add(myNumber);
        }

        Random rand = new Random();
        ArrayList<Integer> lottoNumbers = new ArrayList<>();

        while(lottoNumbers.size() < 6){
            int number = rand.nextInt(49)+1;
            if(!lottoNumbers.contains(number)){
                lottoNumbers.add(number);
            }
        }

        int matches = 0;

        for(int number : myNumbers){
            if(lottoNumbers.contains(number)){
                matches++;
            }
        }

        int i=1;
        while(matches != 6){
            int number = rand.nextInt(49)+1;
            if(!lottoNumbers.contains(number)){
                lottoNumbers.add(number);
                i++;
            }
        }

        System.out.println("Wynik losowania: " + lottoNumbers);
        System.out.println("Twoje liczby: " + myNumbers);
        System.out.println("Trafiles: " + matches + " liczb.");
        System.out.println("Liczba prob: " + i);
    }
}