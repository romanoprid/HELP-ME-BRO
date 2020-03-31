package ua.lviv.iot.spring.database.rest.model;

import java.util.Comparator;

public class CompareByPrice implements Comparator<Good> {
    @Override
    public final int compare(final Good goods, final Good t1) {
        return Double.compare(goods.getPriceInUAH(), t1.getPriceInUAH());
    }
}


