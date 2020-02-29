public class DayOfProgrammer {

    public static void main(String[] args) {
        System.out.println(dayOfProgrammer(1800));
    }

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        int minus = 0;
        if(year < 1918) {
            minus = (year % 4 == 0) ? 1 : 0;
        } else {
            minus = (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ) ? 1 : 0);
        }
        return String.format("%d.%s.%d",year == 1918 ? 26 : 13 - minus, "09", year);
    }
}
