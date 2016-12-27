package ua.demitt.homework.helloworld.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.LinkedList;
import java.util.List;

public enum Period {
    MORNING(LocalTime.of(6, 0), "greeting.morning"),
    DAY(LocalTime.of(9, 0), "greeting.day"),
    EVENING(LocalTime.of(19, 0), "greeting.evening"),
    NIGHT(LocalTime.of(23, 0), "greeting.night")
    ;

    private LocalTime lowerBound;
    private String greetingPropName;
    private static List<Period> order = new ArrayList<>();

    static {
        /*order = new LinkedList<>(Arrays.asList(
            MORNING, DAY, EVENING, NIGHT
        ));*/
        order.addAll(Arrays.asList(
            MORNING, DAY, EVENING, NIGHT
        ));
    }

    Period(LocalTime lowerBound, String greetingPropName) {
        this.lowerBound = lowerBound;
        this.greetingPropName = greetingPropName;
    }

    public static Period getPeriod(LocalTime time) {
        for (Period currentPeriod : order) {
            if ( isIntoPeriod(time, currentPeriod) ) {
                return currentPeriod;
            }
        }
        throw new IllegalStateException("...");
    }

    private static boolean isIntoPeriod(LocalTime time, Period period) {
        LocalTime lowerBound = period.getLowerBound();
        return
            (time.isAfter(lowerBound) || time.equals(lowerBound)) &&
            time.isBefore(getNext(period).getLowerBound())
        ;
    }

    private static Period getNext(Period period) {
        int index = order.indexOf(period);
        int nextIndex = ++index != order.size() ? index : 0 ;
        return order.get(nextIndex);
    }

    public LocalTime getLowerBound() {
        return lowerBound;
    }

    public String getGreetingPropName() {
        return greetingPropName;
    }

}
