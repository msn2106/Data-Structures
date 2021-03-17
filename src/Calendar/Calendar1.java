package Calendar;
import java.time.*;
import java.util.Calendar;

public class Calendar1 {
    public static void main(String[] args) {

        LocalDateTime dt = LocalDateTime.now();
        System.out.println("Date and Time:"+dt);

        LocalDate d = LocalDate.now();
        System.out.println("Local Date:"+d);
        System.out.println("Local Year:"+d.getYear());
        System.out.println("Local Day:"+d.getDayOfWeek());

        LocalDate d2 = LocalDate.of(1995, Month.JUNE,21);
        System.out.println("Sample Date:"+d2);

        LocalTime t1 = LocalTime.now();
        System.out.println("Local Time:"+t1);
        System.out.println("Local hour:"+t1.getHour());

        //human readable
        LocalTime t2 = LocalTime.now(ZoneId.of("GMT"));
        System.out.println("Zone GMT:"+t2);

        //machine readable
        Instant i = Instant.now();
        System.out.println("GMT TIMES:"+i);

        //for finding various ZoneID Strings
//        for(String s: ZoneId.getAvailableZoneIds()){
//            System.out.println(s);
//        }

        Calendar cl1 = Calendar.getInstance();
        System.out.println("Calendar class getInstance:");
        System.out.println(cl1);
    }
}
