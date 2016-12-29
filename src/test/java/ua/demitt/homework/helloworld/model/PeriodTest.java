package ua.demitt.homework.helloworld.model;

import org.junit.Test;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PeriodTest {

    @Test
    public void testGetPeriod() throws Exception {
        //Given
        List<TimeAndPeriod> data = Arrays.asList(
            new TimeAndPeriod(LocalTime.of(6, 0, 0), Period.MORNING),
            new TimeAndPeriod(LocalTime.of(6, 0, 1), Period.MORNING),
            new TimeAndPeriod(LocalTime.of(7, 0, 0), Period.MORNING),
            new TimeAndPeriod(LocalTime.of(8, 59, 59), Period.MORNING),
            new TimeAndPeriod(LocalTime.of(9, 0, 0), Period.DAY),
            new TimeAndPeriod(LocalTime.of(9, 0, 1), Period.DAY),
            new TimeAndPeriod(LocalTime.of(10, 0, 0), Period.DAY),
            new TimeAndPeriod(LocalTime.of(18, 59, 59), Period.DAY),
            new TimeAndPeriod(LocalTime.of(19, 0, 0), Period.EVENING),
            new TimeAndPeriod(LocalTime.of(19, 0, 1), Period.EVENING),
            new TimeAndPeriod(LocalTime.of(20, 0, 0), Period.EVENING),
            new TimeAndPeriod(LocalTime.of(22, 59, 59), Period.EVENING),
            new TimeAndPeriod(LocalTime.of(23, 0, 0), Period.NIGHT),
            new TimeAndPeriod(LocalTime.of(23, 0, 1), Period.NIGHT),
            new TimeAndPeriod(LocalTime.of(0, 0, 0), Period.NIGHT),
            new TimeAndPeriod(LocalTime.of(1, 0, 0), Period.NIGHT),
            new TimeAndPeriod(LocalTime.of(5, 59, 59), Period.NIGHT)
        );
        int size = data.size();
        List<Period> result = new ArrayList<>(size);

        //When
        for (TimeAndPeriod current : data) {
            result.add( Period.getPeriod(current.getTime()) );
        }

        //Then
        for (int i = 0; i < size; i++) {
            assertEquals(
                "Ошибочно определен промежуток для времени " + data.get(i).getTime(),
                data.get(i).getPeriod(),
                result.get(i)
            );
        }
    }


    private class TimeAndPeriod {
        private LocalTime time;
        private Period period;

        public TimeAndPeriod(LocalTime time, Period period) {
            this.time = time;
            this.period = period;
        }

        public LocalTime getTime() {
            return time;
        }

        public Period getPeriod() {
            return period;
        }
    }

}