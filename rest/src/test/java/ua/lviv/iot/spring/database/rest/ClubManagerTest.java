package ua.lviv.iot.spring.database.rest;


import org.junit.jupiter.api.Test;
import ua.lviv.iot.spring.database.rest.manager.ClubManager;
import ua.lviv.iot.spring.database.rest.model.Good;
import ua.lviv.iot.spring.database.rest.model.Purpose;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClubManagerTest extends ClubManager {

    @Test
    public void add() {
        ClubManager clubManager = new ClubManager();
        clubManager.add(new Good("Helmet", 200, "North", "Ukraine",
                "Leather", Purpose.GOALKEEPER));
        clubManager.add(new Good("HockeyPuck", 150, "North", "Ukraine",
                "Wood", Purpose.GOALKEEPER));
        String expected = "Name=Helmet PriceInUAH=200.0 Producer=North ProducingCountry=Ukraine Material=Leather Purpose=GOALKEEPER\n" +
                "Name=HockeyPuck PriceInUAH=150.0 Producer=North ProducingCountry=Ukraine Material=Wood Purpose=GOALKEEPER\n";
        String actual = clubManager.toString();
        assertEquals(expected, actual);


    }

    @Test
    public void find() {
        ClubManager clubManager = new ClubManager();
        clubManager.add(new Good("Helmet", 200.0, "North", "Ukraine",
                "Leather", Purpose.GOALKEEPER));
        clubManager.add(new Good("HockeyPuck", 150.0, "North", "Ukraine",
                "Wood", Purpose.FIELDPLAYER));
        clubManager.add(new Good("Helmet", 200.0, "North", "Ukraine",
                "Leather", Purpose.GOALKEEPER));
        List<Good> expected = new LinkedList<Good>();
        expected.add(new Good("Helmet", 200.0, "North", "Ukraine", "Leather", Purpose.GOALKEEPER));
        expected.add(new Good("Helmet", 200.0, "North", "Ukraine", "Leather", Purpose.GOALKEEPER));
        List<Good> actual = clubManager.find(Purpose.GOALKEEPER);
        assertEquals(expected, actual);
    }

    @Test
    public void findMinPrice() {
        ClubManager clubManager = new ClubManager();
        clubManager.add(new Good("Helmet", 200.0, "North", "Ukraine",
                "Leather", Purpose.GOALKEEPER));
        clubManager.add(new Good("HockeyPuck", 150.0, "North", "Ukraine",
                "Wood", Purpose.GOALKEEPER));
        clubManager.add(new Good("Helmet", 200.0, "North", "Ukraine",
                "Leather", Purpose.GOALKEEPER));
        clubManager.add(new Good("Helmet", 150.0, "North", "Ukraine",
                "Leather", Purpose.GOALKEEPER));
        List<Good> expected = new LinkedList<Good>();
        expected.add(new Good("HockeyPuck", 150.0, "North", "Ukraine",
                "Wood", Purpose.GOALKEEPER));
        expected.add(new Good("Helmet", 150.0, "North", "Ukraine", "Leather", Purpose.GOALKEEPER));
        List<Good> actual = clubManager.findMinPrice(Purpose.GOALKEEPER);
        assertEquals(expected, actual);
    }


}