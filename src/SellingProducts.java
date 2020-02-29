import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SellingProducts {


    public static void main(String[] args) {
        System.out.println(deleteProducts(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 5));
        System.out.println(deleteProducts(Arrays.asList(1, 1, 5, 5), 2));
        System.out.println(deleteProducts(Arrays.asList(1, 2, 3, 1, 2, 2, 1), 3));
    }

    public static int deleteProducts(List<Integer> ids, int m) {
        Map<Integer, Long> raw = ids.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> sorted = raw.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));

        for (Map.Entry<Integer, Long> entry : sorted.entrySet()) {
            if (m == 0) break;
            else {
                long c = entry.getValue();
                m -= c;
                if(m < 0) {
                    entry.setValue(c - m);
                } else {
                   entry.setValue(0L);
                }

            }
        }
        return (int) sorted.entrySet().stream().filter(p -> p.getValue() > 0).count();
    }
}
