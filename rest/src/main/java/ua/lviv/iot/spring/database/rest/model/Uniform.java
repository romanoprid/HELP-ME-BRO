package ua.lviv.iot.spring.database.rest.model;


public class Uniform extends Good {
    private Size size;

    public Uniform() {

    }

    public Uniform(final String name, final double priceInUAH, final String producer, final String producingCountry,
                   final String material, final Purpose purpose, final Size uniformSize) {
        super(name, priceInUAH, producer, producingCountry, material, purpose);
        this.size = uniformSize;
    }

    public final Size getSize() {
        return size;
    }

    public final void setSize(final Size uniformSize) {
        this.size = uniformSize;
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
        switch (mass[n]) {
            case "S":
                this.size = Size.S;
                break;
            case "M":
                this.size = Size.M;
                break;
            case "L":
                this.size = Size.L;
                break;
            case "X":
                this.size = Size.X;
                break;
            case "XL":
                this.size = Size.XL;
                break;
            case "XXL":
                this.size = Size.XXL;
                break;
            default:
                this.setSize(Size.M);
        }
    }

    @Override
    public final String getHeaders() {
        return super.getHeaders() + ",size";
    }

    @Override
    public final String toCSV() {
        return super.toCSV() + "," + size;
    }


    @Override
    public final String toString() {
        return super.toString() + " "
                + "Size=" + size;
    }
}
