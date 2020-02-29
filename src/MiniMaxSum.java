import java.util.Arrays;
import java.util.stream.IntStream;

public class MiniMaxSum {

    public static void main(String[] args) {

        int[] arr = { 1,2,3,4,5};

        long max = IntStream.of(arr).max().getAsInt();
        long min = IntStream.of(arr).min().getAsInt();

        long total = 0;
        for(int i : arr) {
            total+=i;
        }
        System.out.println((total - max)+ " " + (total - min));
    }
}
