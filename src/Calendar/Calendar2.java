package Calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar2 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        System.out.println("Get Time:"+date.getTime());

        System.out.println("After:"+date.after(date));
        System.out.println("Before:"+date.before(date));

        System.out.println("toString:"+date.toString());

        System.out.println("Date:"+date.getDate()); //deprecated methods
        System.out.println("Month:"+(1+date.getMonth()));
        System.out.println("Year:"+(1900+date.getYear()));

        System.out.println("Using Date Format Class from java.text");
        System.out.println("Date:"+DateFormat.getDateInstance().format(date));
        System.out.println("Time:"+DateFormat.getTimeInstance().format(date));
        System.out.println("Short Time:"+DateFormat.getTimeInstance(DateFormat.SHORT).format(date));
        System.out.println("Medium Time:"+DateFormat.getTimeInstance(DateFormat.MEDIUM).format(date));
        System.out.println("Long Time:"+DateFormat.getTimeInstance(DateFormat.LONG).format(date));

        System.out.println("Using Simple Date Format Class -------------");

        SimpleDateFormat sd = new SimpleDateFormat();
        System.out.println("Simple Date:"+sd);
        System.out.println("Formart:"+sd.format(date));
        SimpleDateFormat sd2 = new SimpleDateFormat("E dd-MM-yyyy // hh:mm:ss");
        System.out.println("Custom Format:"+sd2.format(date));
        SimpleDateFormat sd3 = new SimpleDateFormat("E dd-MM hh:mm");
        System.out.println("Custom Format2:"+sd3.format(date)); //sd3.format(sd3) is incorrect
    }
}
