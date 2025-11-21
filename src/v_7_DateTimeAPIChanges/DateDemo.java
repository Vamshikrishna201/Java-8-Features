package v_7_DateTimeAPIChanges;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);

        // Converting Date to String
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        String format1 = sdf1.format(date);
        System.out.println("INDIA: " + format1);

        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
        String format2 = sdf2.format(date);
        System.out.println("US: " + format2);


        // Convert String to Date
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        Date parseDate = sdf3.parse("2025-11-19");
        System.out.println(parseDate);
    }
}
