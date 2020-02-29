import java.util.Arrays;
import java.util.List;

public class ChocolateBar {

    public static void main(String[] args) {

        System.out.println(birthday(Arrays.asList(1,2,1,3,2),3,2));
    }

    static int birthday(List<Integer> s, int d, int m) {
        int ctr = 0;
        for(int i=0; i < s.size(); i++) {
            if(i + m > s.size()) break;
            int total = 0;
            for(int j=i; j < i + m; j++) {
                total += s.get(j);
            }
            if(total == d) {
                ctr++;
            }
        }
        return ctr;
    }

    static String kangaroo(int x1, int v1, int x2, int v2) {
        int a = (x1 + v1);
        int b = (x2 + v2);
        if (x2 > x1 && v2 > v1) return "NO";
        if (Math.max(a,b) % Math.min(a,b) == 0) {
            return "YES";
        } else {
            return "NO";
        }

    }
}
