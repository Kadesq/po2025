import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class lotto{
    public static void main (String[] args) {
        Random random = new Random();
    
        Set<Integer> lottoNumbers = new HashSet<>();

        while(lottoNumbers.size() < 6){
            int number = random.nextInt(49)+1;
            lottoNumbers.add(number);
        }

        System.out.println("Wylosowane liczby: " + lottoNumbers);
    }
}   