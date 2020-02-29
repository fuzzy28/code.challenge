import java.util.Arrays;
import java.util.List;

public class SortArrayByEvenNumbersFirst {


    public static void main(String[] args) {

        System.out.println(moves(Arrays.asList(6, 3, 4, 5)));
        System.out.println(moves(Arrays.asList(8, 5, 11, 4, 6)));
    }

    public static int moves(List<Integer> a) {

        int evenOnRight = 0;
        for (int i = a.size() / 2; i < a.size(); i++) {
            if (a.get(i) % 2 == 0) evenOnRight++;
        }
        return evenOnRight;
    }
}
