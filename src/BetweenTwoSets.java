import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BetweenTwoSets {

    public static void main(String[] args) {
        System.out.println(getTotalX(new ArrayList<>(Arrays.asList(2,4)), new ArrayList<>(Arrays.asList(16,32,96))));
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        a.addAll(b);
        Collections.sort(a);

        int ctr = 0;
        int factor = a.get(a.size() - 1) % a.get(a.size() - 2);
        for(int c = a.size() -1; c > 0 ; c--) {
            boolean result = true;
            for(int i = a.size() - 1; i >=0; i--) {
                if(a.get(i) % factor != 0) {
                    result = false;
                    break;
                }
            }
            if(result) {
                ctr++;
            }
            factor = a.get(c);
            if (factor == 0) break;
        }

        return ctr;
    }
}
