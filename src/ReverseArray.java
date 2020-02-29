public class ReverseArray {


    public static void main(String[] args) {
        int[] a = {4, 3, 2, 1};
        print(a);
        reverseArray(a);
        System.out.println();
        print(a);
    }

    static void print(int[] a) {
        for(int i : a) {
            System.out.print(i + " ");
        }
    }

    static int[] reverseArray(int[] a) {
        int len = a.length -1;
        for(int i =0; i <= len; i++) {
            int leftVal = a[i];
            a[i] = a[len];
            a[len--] = leftVal;
        }
        return a;
    }


}
