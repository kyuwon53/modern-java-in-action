package chapter12;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextWorkingDay implements TemporalAdjuster {

    public static final int DEFAULT_DAY_TO_ADD = 1;
    public static final int FRIDAY_TO_ADD = 3;
    public static final int SATURDAY_TO_ADD = 2;

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek now = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        if (now == DayOfWeek.FRIDAY) {
            return temporal.plus(FRIDAY_TO_ADD, ChronoUnit.DAYS);
        }
        if (now == DayOfWeek.SATURDAY) {
            return temporal.plus(SATURDAY_TO_ADD, ChronoUnit.DAYS);
        }
        return temporal.plus(DEFAULT_DAY_TO_ADD, ChronoUnit.DAYS);
    }
}
