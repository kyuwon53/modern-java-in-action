package chapter12;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Quiz1 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 3, 18);
        date = date.with(ChronoField.MONTH_OF_YEAR, 9); // 달을 9로 지정
        date = date.plusYears(2).minusDays(10); // 년도 +2, 날짜 -10
        date.withYear(2011);    // 2011-09-08 새로운 객체
        // Q. date 출력값은?
        // a. 2016-09-08
        System.out.println("date = " + date);
    }
}
