package Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calendar3 {
    public static void main(String[] args) {
//        SimpleDateFormat sd = new SimpleDateFormat();
//        Calendar cd1 = new GregorianCalendar();
//        System.out.println("Gregorian Date:"+cd1); //works same as the below one
//        System.out.println("getInstance method:"+Calendar.getInstance());
//        System.out.println("Year:"+cd1.get(Calendar.YEAR));
//        System.out.println("Month:"+cd1.get(Calendar.MONTH));
//        System.out.println("Full Date and Time:"+cd1.getTime());
//        System.out.println("Format Date:"+ sd.format(cd1.getTime()));
//
//        SimpleDateFormat sd2 = new SimpleDateFormat("E dd-MM // hh:mm");
//        System.out.println("New format:"+sd2.format(cd1.getTime()));
//
//        Date date = new Date();
//        System.out.println(date.getDay());

        String day = findDay(8,05 ,2015);
        System.out.println(day);

    }

    public static String findDay(int month, int dy, int year) {
        Calendar cd = new GregorianCalendar();
        cd.set(year,month,dy);
        int day = cd.get(Calendar.DAY_OF_WEEK);
        System.out.println(day);
        return "";
    }
}
