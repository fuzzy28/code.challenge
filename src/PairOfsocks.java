import java.util.HashMap;
import java.util.Map;

public class PairOfsocks {

    public static void main(String[] args) {
        System.out.println(sockMerchant(9,new int [] {10,20,20,10,10,30,50,10,20}));
    }

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> socks = new HashMap<>();
        for(int i: ar)
            socks.merge(i, 1,Integer::sum);
        return socks.values().stream().filter(x -> x > 1).mapToInt(x-> ((x % 2 == 0) ? x : x -1) / 2).sum();
    }
}
