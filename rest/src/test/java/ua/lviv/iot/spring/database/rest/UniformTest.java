package ua.lviv.iot.spring.database.rest;


import org.junit.jupiter.api.Test;
import ua.lviv.iot.spring.database.rest.model.Purpose;
import ua.lviv.iot.spring.database.rest.model.Size;
import ua.lviv.iot.spring.database.rest.model.Uniform;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniformTest {

    @Test
    public void testToString() {
        Uniform uniform = new Uniform("Sweater", 100, "North", "Ukraine",
                "Silk", Purpose.GOALKEEPER, Size.XL);
        String expected = "Name=Sweater PriceInUAH=100.0 Producer=North ProducingCountry=Ukraine Material=Silk Purpose=GOALKEEPER Size=XL";
        String actual = uniform.toString();
        assertEquals(expected, actual);
    }
}
