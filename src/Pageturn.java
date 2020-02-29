public class Pageturn {

    public static void main(String[] args) {
        System.out.println(pageCount(7,3));
        System.out.println(pageCount(5,4));
    }

    static int pageCount(int n, int p) {
        if(n==p) return 0;
        return Math.min(p/2, n/2 - (p/2));
    }
}
