package Calendar;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendar4 {
    public static void main(String[] args) {
        Calendar c = new GregorianCalendar();
        //c.setLenient(false);

        c.set(2015,8,05);

        //rolls the integer passed within the same value, here date of the month
        //c.roll(Calendar.DATE,50);
        System.out.println(c.getTime());
        System.out.println();

        LocalDate ld = LocalDate.of(2015,8,05);
        String day = (ld.getDayOfWeek().toString());
        System.out.println(day);
    }
}
