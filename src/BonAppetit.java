import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BonAppetit {

    public static void main(String[] args) {
        bonAppetit(new ArrayList<>(Arrays.asList(3,10,2,9)), 1, 12);
    }

    static void bonAppetit(List<Integer> bill, int k, int b) {
        bill.remove(bill.get(k));
        int total = bill.stream().mapToInt(Integer::valueOf).sum() / 2;
        System.out.println(total == b ? "Bon apettit" : b - total);
    }
}
