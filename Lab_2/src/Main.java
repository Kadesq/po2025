import java.util.*;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> myNumbers = new ArrayList<>();
        for (String arg : args) {
            int myNumber = Integer.parseInt(arg);
            myNumbers.add(myNumber);
        }

        Random rand = new Random();
        long start = System.currentTimeMillis();

        int matches = 0;
        int attemps = 0;

        ArrayList<Integer> lottoNumbers = new ArrayList<>();

        while(matches != 6){
            lottoNumbers.clear();

            while(lottoNumbers.size() < 6){
                int number = rand.nextInt(49)+1;
                if(!lottoNumbers.contains(number)){
                    lottoNumbers.add(number);
                }
            }

            matches=0;

            for(int number : lottoNumbers){
                if(lottoNumbers.contains(number)){
                    matches++;
                }
            }

            attemps++;
        }

        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("Wynik losowania: " + lottoNumbers);
        System.out.println("Twoje liczby: " + myNumbers);
        System.out.println("Trafiles: " + matches + " liczb.");
        System.out.println("Liczba prob: " + attemps + " liczb.");
    }
}