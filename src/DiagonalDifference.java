import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class DiagonalDifference {


    public static void main(String[] args) {
        List<List<Integer>> arrs = Arrays.asList(
          Arrays.asList(8,2,4), Arrays.asList(4,5,6), Arrays.asList(7,8,9)
        );
        System.out.println(diagonalDifference(arrs));
    }


    public static int diagonalDifference(List<List<Integer>> arr) {
        int totalDL = 0;
        int totalRL = 0;
        for (int i =0,j= arr.size() -1 ; i< arr.size(); i++, j--) {
             totalDL += arr.get(i).get(i);
             totalRL += arr.get(i).get(j);
        }
        return totalDL - totalRL;
    }

}
