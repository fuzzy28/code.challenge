public class HourGlass {

    public static void main(String[] args) {
        int[][] arr = {
                {-1, -1, 0, -9, -2, -2},
                {-2,-1,-6,-8,-2,-5},
                {-1,-1,-1,-2,-3,-4},
                {-1,-9,-2,-4,-4,-5},
                {-7,-3,-3,-2,-9,-9},
                {-1,-3,-1,-2,-4,-5}
        };

        System.out.println(hourglassSum(arr));
    }

    static int hourglassSum(int[][] arr) {
        int max = -100000;
        for(int r = 1; r < arr.length - 1; r++) {
            for(int c = 1; c < arr[r].length - 1 ; c++) {
                int[] adjacentRows = {r - 1, r + 1};
                int[] adjacentCols = {c - 1, c, c + 1};
                int total = arr[r][c];
                for(int i: adjacentRows) {
                    for(int j: adjacentCols) {
                        total+=arr[i][j];
                    }
                }
                if (total > max) {
                    max = total;
                }
            }
        }
        return max;
    }
}
