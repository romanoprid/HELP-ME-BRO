package ua.lviv.iot.spring.database.rest.model;


import java.util.Comparator;

public class CompareForFindPrice implements Comparator<Good> {
    @Override
    public final int compare(final Good good, final Good t1) {
        return Double.compare(good.getPriceInUAH(), t1.getPriceInUAH());
    }
}
