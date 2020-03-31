package ua.lviv.iot.spring.database.rest.model;

public class IceSkates extends Good {
    private double footSize;

    public IceSkates() {

    }

    public IceSkates(final String name, final double priceInUAH, final String producer, final String producingCountry,
                     final String material, final Purpose purpose, final double foot) {
        super(name, priceInUAH, producer, producingCountry, material, purpose);

        this.footSize = foot;
    }


    public final double getFootSize() {
        return footSize;
    }

    public final void setFootSize(final double foot) {
        this.footSize = foot;
    }


    public final void parse(final String s) {
        System.out.println(s);
        String[] mass = s.split(",");
        int n = 0;
        this.setName(mass[n]);
        System.out.println(mass[n]);
        n++;
        this.setPriceInUAH(Double.parseDouble(mass[n]));
        n++;
        System.out.println("" + getPriceInUAH());
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
        this.footSize = Double.parseDouble(mass[n]);
        System.out.println("" + footSize);
    }

    @Override
    public final String getHeaders() {
        return super.getHeaders() + ",footSize";
    }

    @Override
    public final String toCSV() {
        return super.toCSV() + "," + footSize;
    }


    @Override
    public final String toString() {
        return super.toString() + " "
                + "FootSize=" + footSize;
    }

}
