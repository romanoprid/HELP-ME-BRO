package ua.lviv.iot.spring.database.rest;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.spring.database.rest.manager.ClubManager;
import ua.lviv.iot.spring.database.rest.manager.ClubWriter;
import ua.lviv.iot.spring.database.rest.model.Good;
import ua.lviv.iot.spring.database.rest.model.Purpose;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ClubWriterTest extends ClubManager {

    @Test
    public void readFile() {


        String input = "List.csv";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        ClubManager clubManager = new ClubManager();
        clubManager.add(new Good("Hockey", 100, "North", "Ukraine",
                "Leather", Purpose.GOALKEEPER));
        clubManager.add(new Good("Sweater", 100, "Gan", "Ukraine",
                "Leather", Purpose.GOALKEEPER));
        clubManager.add(new Good("Helmet", 100, "Tiger", "Ukraine",
                "Leather", Purpose.GOALKEEPER));
    }


    @Test
    void writeToFile() {
        ClubWriter clubWriter = new ClubWriter();
        List<Good> goods = new ArrayList<Good>();
        goods.add(new Good("Hockey", 100, "North", "Ukraine",
                "Leather", Purpose.GOALKEEPER));
        goods.add(new Good("Hockey", 100, "North", "Ukraine",
                "Leather", Purpose.GOALKEEPER));
        goods.add(new Good("Sweater", 100, "Gan", "Ukraine",
                "Leather", Purpose.GOALKEEPER));
        goods.add(new Good("Helmet", 100, "Tiger", "Ukraine",
                "Leather", Purpose.GOALKEEPER));
        clubWriter.writeToFile(goods);
    }
}