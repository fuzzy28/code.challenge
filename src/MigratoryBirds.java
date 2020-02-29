import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MigratoryBirds {

    public static void main(String[] args) {
        System.out.println(migratoryBirds(Arrays.asList(1,2,3,4,5,4,3,2,1,3,4)));
    }

    static int migratoryBirds(List<Integer> arr) {
        Map<Integer,Integer> birds = new HashMap<>();
        arr.stream().forEach(x -> {birds.merge(x,1, Integer::sum);});
        return birds.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }
}
