import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ClusterQuality {

    public static void main(String[] args) {
        System.out.println(maximumClusterQuality(Arrays.asList(4,
                3,
                15,
                5,
                6), Arrays.asList(7,
                6,
                1,
                2,
                8), 3));

        System.out.println(maximumClusterQuality(Arrays.asList(12,
                112,
                100,
                13,
                55), Arrays.asList(31,
                4,
                100,
                55,
                50), 3));
    }

    public static long maximumClusterQuality2(List<Integer> speed, List<Integer> reliability, int maxMachines) {
        Map<Integer, Integer> r = new LinkedHashMap<>();
        for (int i = 0; i < reliability.size(); i++) {
            r.put(i, reliability.get(i));
        }
        Map<Integer, Integer> sorted = r.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));

        Map<Integer, Integer> raw = new LinkedHashMap<>();
        int total = 0;

        for (Map.Entry<Integer, Integer> v : sorted.entrySet()) {
            if (maxMachines == 0) break;
            raw.put(v.getKey(), v.getValue());
            maxMachines--;
            total += speed.get(v.getKey());
        }

        Map.Entry<Integer,Integer> first = raw.entrySet().iterator().next();
        return Math.max( total * Collections.min(raw.values()), speed.get(first.getKey()) * first.getValue());
    }

    public static long maximumClusterQuality(List<Integer> speed, List<Integer> reliability, int maxMachines) {
        Map<Integer, Integer> r = new LinkedHashMap<>();
        for (int i = 0; i < reliability.size(); i++) {
            r.put(i, reliability.get(i));
        }
        Map<Integer, Integer> sorted = r.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));
        int maxCluster = 0;
        List<Map.Entry<Integer,Integer>> sortedList = new ArrayList<>(sorted.entrySet());
        for(int i = 1; i <= maxMachines; i++) {

            List<Map.Entry<Integer,Integer>> currentCluster = sortedList.subList(0,i);

           int totspeed = currentCluster.stream().mapToInt(x -> Integer.valueOf(speed.get(x.getKey()).toString())).sum();
           int totreli = currentCluster.stream().mapToInt(x -> Integer.valueOf(x.getValue().toString())).min().getAsInt();
           int total = totspeed * totreli;
           if (total > maxCluster) {
               maxCluster = total;
           }
        }
        return maxCluster;
    }
}
