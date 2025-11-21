package v_7_DateTimeAPIChanges;

import java.time.*;
import java.util.Date;

//example 2 for java 8
public class NewDateDemo {
    public static void main(String[] args) {

        LocalDate of = LocalDate.of(2023, 3, 07);
        System.out.println(of);

        //new way
        LocalDate d2 = LocalDate.now();
        System.out.println(d2); // 2025-11-19

        d2 = d2.plusDays(2);
        System.out.println(d2); //2025-11-22

        d2 = d2.plusMonths(2);
        System.out.println(d2); //2026-01-22

        d2 = d2.plusYears(1);
        System.out.println(d2); //2027-01-22

        boolean leapYear = LocalDate.parse("2024-11-21").isLeapYear();
        System.out.println("Leap Year :: " + leapYear); // true

        boolean before = LocalDate.parse("2021-12-22").isBefore(LocalDate.parse("2022-12-22"));
        System.out.println("Before Date : " + before);

        LocalTime time = LocalTime.now();
        System.out.println(time);
        time = time.plusHours(2);
        System.out.println(time);

        LocalDateTime datetime = LocalDateTime.now();
        System.out.println(datetime);

        Period between = Period.between(LocalDate.parse("2001-05-05"), LocalDate.now());
        System.out.println(between);

        Duration duration = Duration.between(LocalTime.parse("20:42"), LocalTime.now());
        System.out.println(duration);
    }
}
