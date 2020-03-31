package ua.lviv.iot.spring.database.rest;


import org.junit.jupiter.api.Test;
import ua.lviv.iot.spring.database.rest.model.Purpose;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HockeyPuckTest {

    @Test
    public void testToString() {
        HockeyPuck hockeyPuck = new HockeyPuck("HockeyPuck", 100, "Gan", "Ukraine",
                "Leather", Purpose.GOALKEEPER, 4.1);
        String expected = "Name=HockeyPuck PriceInUAH=100.0 Producer=Gan ProducingCountry=Ukraine Material=Leather Purpose=GOALKEEPER Thickness=4.1 Id = 1 ";
        String actual = hockeyPuck.toString();
        assertEquals(expected, actual);

    }
}