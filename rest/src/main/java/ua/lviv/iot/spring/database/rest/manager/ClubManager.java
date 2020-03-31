package ua.lviv.iot.spring.database.rest.manager;


import ua.lviv.iot.spring.database.rest.HockeyPuck;
import ua.lviv.iot.spring.database.rest.model.*;
import ua.lviv.iot.spring.database.rest.model.Good;
import ua.lviv.iot.spring.database.rest.model.Purpose;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class ClubManager {
    public class InnerCompareByName implements Comparator<Good> {
        @Override
        public final int compare(final Good good, final Good t1) {
            return good.getName().compareTo(t1.getName());
        }
    }


    public static class InnerStaticCompareByPrice implements Comparator<Good> {
        @Override
        public final int compare(final Good goods, final Good t1) {
            return Double.compare(goods.getPriceInUAH(), t1.getPriceInUAH());
        }
    }

    public final static int COUNT_PARAMETRS_GOOD = 5;
    public final static int COUNT_PARAMETRS_HOCKEY_PUCK = 7;

    protected List<Good> goods;

    public ClubManager() {
        this.goods = new LinkedList<Good>();
    }

    public final void add(final Good good) {
        this.goods.add(good);
    }

    public final List<Good> find(final Purpose purpose) {
        List<Good> res = new LinkedList<>();
        for (Good g : this.goods) {
            if (g.getPurpose() == purpose) {
                res.add(g);
            }
        }
        return res;
    }


    public final void sortByName(final boolean isIncrease) {
        if (isIncrease) {
            this.goods.sort(new CompareByName());
        } else {
            this.goods.sort(new CompareByNameDecrease());
        }
    }

    public final void sortByPrice(final boolean isIncrease) {
        if (isIncrease) {
            this.goods.sort(new CompareByPrice());
        } else {
            this.goods.sort(new CompareByPriceDecrease());
        }
    }

    public final List<Good> findMinPrice(final Purpose purpose) {
        List<Good> res = new LinkedList<Good>();
        List<Good> purposeGoods = new LinkedList<Good>();
        for (Good g : goods) {
            if (g.getPurpose() == purpose) {
                purposeGoods.add(g);
            }
        }
        Good minGood = Collections.min(purposeGoods, new CompareForFindPrice());
        Iterator<Good> it = goods.iterator();
        while (it.hasNext()) {
            Good g = it.next();
            if ((g.getPurpose() == purpose) && (g.getPriceInUAH() == minGood.getPriceInUAH())) {
                res.add(g);
            }
            System.out.println(res);
        }
        return res;
    }


    public final void sortByProducer() {
        Collections.sort(goods, new Comparator<Good>() {
            @Override
            public int compare(final Good o1, final Good o2) {
                return o1.getProducer().compareTo(o2.getProducer());
            }
        });
    }

    public final void sortByMaterial() {
        goods.sort((Good o1, Good o2) -> o1.getMaterial().compareTo(o2.getMaterial()));
    }


    public final String getHeaders() {
        return "goods";
    }

    public final String toCSV() {
        String s = "";
        for (Good g : goods) {
            s += g.toCSV();
        }
        return s;
    }


    public final void readFromFile(final String fileName) {
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter(",");
            scanner.nextLine();
            this.goods.clear();
            while (scanner.hasNext()) {
                String result = scanner.nextLine();
                String[] mass = result.split(",");
                Good g = null;
                switch (mass.length) {
                    case COUNT_PARAMETRS_GOOD:
                        g = new Good();
                        break;
                    case COUNT_PARAMETRS_HOCKEY_PUCK:
                        g = new HockeyPuck();
                    default:
                        break;
                }
                g.parse(result);
                goods.add(g);
            }

            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            ex.getStackTrace();
        }
    }


    @Override
    public String toString() {
        String res = "";
        for (Good g : this.goods) {
            res += g.toString() + "\n";
        }
        return res;
    }

}
