package ua.demitt.homework.helloworld.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.demitt.homework.helloworld.exception.PeriodNotFoundException;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public enum Period {
    MORNING(LocalTime.of(6, 0), "greeting.morning"),
    DAY(LocalTime.of(9, 0), "greeting.day"),
    EVENING(LocalTime.of(19, 0), "greeting.evening"),
    NIGHT(LocalTime.of(23, 0), "greeting.night")
    ;

    private static final Logger LOG = LoggerFactory.getLogger("Period");

    private LocalTime lowerBound;
    private String greetingPropName;
    private static List<Period> order;

    static {
        order = Arrays.asList(
            MORNING, DAY, EVENING, NIGHT
        );
    }

    Period(LocalTime lowerBound, String greetingPropName) {
        this.lowerBound = lowerBound;
        this.greetingPropName = greetingPropName;
    }

    public static Period getPeriod(LocalTime time) {
        LOG.info("Искомое время " + time + ", начинаем цикл по имеющимся промежуткам");

        for (Period currentPeriod : order) {
            LOG.info("Текущий промежуток = " + currentPeriod);
            if ( isIntoPeriod(time, currentPeriod) ) {
                LOG.info("Промежуток определен (" + currentPeriod + "), завершаем цикл по имеющимся промежуткам");
                return currentPeriod;
            }
        }

        LOG.info("Промежуток для момента времени " + time + " не найден!");
        throw new PeriodNotFoundException("Не найден промежуток для момента времени " + time);
    }

    private static boolean isIntoPeriod(LocalTime time, Period period) {
        LocalTime lowerBound = period.getLowerBound();
        LocalTime upperBound = getNext(period).getLowerBound();
        boolean isAfterLowerBound = isAfterOrEqualsThanLowerBound(time, lowerBound);
        boolean isBeforeUpperBound = time.isBefore(upperBound);

        LOG.info(
            "Время = " + time + ", текущий промежуток = " + period + " (" + lowerBound + "-" + upperBound + ")"
        );

        boolean isInto =
            isAfterLowerBound && isBeforeUpperBound
            ||
            lowerBound.isAfter(upperBound) && ( isAfterLowerBound || isBeforeUpperBound )
        ;
        LOG.info("Попадает ли время в текущий промежуток: " + (isInto ? "да" : "нет"));

        return isInto;
    }

    private static Period getNext(Period period) {
        int index = order.indexOf(period);
        int nextIndex = ++index != order.size() ? index : 0 ;
        return order.get(nextIndex);
    }

    private static boolean isAfterOrEqualsThanLowerBound(LocalTime time, LocalTime lowerBound) {
        return time.isAfter(lowerBound) || time.equals(lowerBound);
    }

    public LocalTime getLowerBound() {
        return lowerBound;
    }

    public String getGreetingPropName() {
        return greetingPropName;
    }

}
