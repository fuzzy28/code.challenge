public class TimeConversion {

    public static void main(String[] args) {
        System.out.println(timeConversion("12:40:22AM"));
    }

    static String timeConversion(String s) {
        String[] splitted = s.toUpperCase().split(":");
        int hour = Integer.parseInt(splitted[0]);
        if(s.toUpperCase().contains("P")) {
            hour +=12;
        } else {
            hour -=12;
        }
        s = String.format("%02d:%s:%s",hour,splitted[1],splitted[2]);
        return s.replaceAll("AM","").replaceAll("PM","");
    }
}
