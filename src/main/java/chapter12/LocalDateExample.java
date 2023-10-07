package chapter12;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2023, 10, 7);
        LocalDate date2 = date1.withYear(2022);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 2);

        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
        System.out.println("date3 = " + date3);
        System.out.println("date4 = " + date3);
        /*
         * 기존 객체를 수정하는 것이 아니라, 새로운 객체를 반환한다.
         * */

        System.out.println("date1==date2 = " + (date1 == date2));
        System.out.println("date2==date3 = " + (date2 == date3));
        System.out.println("date3==date4 = " + (date3 == date4));
        System.out.println("date1==date3 = " + (date1 == date3));
        System.out.println("date1==date4 = " + (date1 == date4));
    }
}
