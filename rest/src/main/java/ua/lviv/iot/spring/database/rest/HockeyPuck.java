package ua.lviv.iot.spring.database.rest;

import ua.lviv.iot.spring.database.rest.model.Good;
import ua.lviv.iot.spring.database.rest.model.Purpose;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HockeyPuck extends Good {
    private double thickness;
@Id

    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HockeyPuck() {
    }

    public HockeyPuck(final String name, final double priceInUAH, final String producer, final String producingCountry,
                      final String material, final Purpose purpose, final double thick) {
        super(name, priceInUAH, producer, producingCountry, material, purpose);
        this.thickness = thick;

    }

    public final double getThickness() {
        return thickness;
    }

    public final void setThickness(final double thick) {
        this.thickness = thick;
    }


    public final void parse(final String s) {
        System.out.println(s);
        String[] mass = s.split(",");
        int n = 0;
        this.setName(mass[n]);
        System.out.println(mass[n]);
        n++;
        this.setPriceInUAH(Double.parseDouble(mass[n]));
        System.out.println("" + getPriceInUAH());
        n++;
        this.setProducer(mass[n]);
        n++;
        this.setProducingCountry(mass[n]);
        n++;
        this.setMaterial(mass[n]);
        n++;
        switch (mass[n]) {
            case "GOALKEEPER":
                this.setPurpose(Purpose.GOALKEEPER);
                break;
            case "FIELDPLAYER":
                this.setPurpose(Purpose.FIELDPLAYER);
                break;
            default:
                this.setPurpose(Purpose.FIELDPLAYER);
        }
        n++;
        this.thickness = Double.parseDouble(mass[n]);
        System.out.println("" + thickness);
    }

    @Override
    public final String getHeaders() {
        return super.getHeaders() + ",thickness";
    }

    @Override
    public final String toCSV() {
        return super.toCSV() + "," + thickness;
    }

    @Override
    public final String toString() {
        return super.toString() + " "
                + "Thickness=" + thickness + " ";
    }

}
