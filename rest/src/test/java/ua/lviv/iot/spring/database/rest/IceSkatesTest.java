package ua.lviv.iot.spring.database.rest;


import org.junit.jupiter.api.Test;
import ua.lviv.iot.spring.database.rest.model.IceSkates;
import ua.lviv.iot.spring.database.rest.model.Purpose;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IceSkatesTest {

    @Test
    public void testToString() {
        IceSkates iceSkates = new IceSkates("IceSkates", 100, "Gan", "Ukraine",
                "Leather", Purpose.GOALKEEPER,41.5);
        String expected = "Name=IceSkates PriceInUAH=100.0 Producer=Gan ProducingCountry=Ukraine Material=Leather Purpose=GOALKEEPER FootSize=41.5";
        String actual = iceSkates.toString();
        assertEquals(expected, actual);
    }
}