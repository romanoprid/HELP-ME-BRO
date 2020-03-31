package ua.lviv.iot.spring.database.rest.model;

public class ProtectiveClothes extends Good {
    private Level protectionLevel;

    public ProtectiveClothes() {

    }

    public ProtectiveClothes(final String name, final double priceInUAH, final String producer,
                             final String producingCountry,
                             final String material, final Purpose purpose, final Level protection) {
        super(name, priceInUAH, producer, producingCountry, material, purpose);
        this.protectionLevel = protection;
    }


    public final Level getProtectionLevel() {
        return protectionLevel;
    }

    public final void setProtectionLevel(final Level protection) {
        this.protectionLevel = protection;
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
        switch (mass[n]) {
            case "HIGH":
                this.protectionLevel = Level.HIGH;
                break;
            case "MEDIUM":
                this.protectionLevel = Level.MEDIUM;
                break;
            case "LOW":
                this.protectionLevel = Level.LOW;
                break;
            default:
                this.setProtectionLevel(Level.MEDIUM);
        }
    }


    @Override
    public final String getHeaders() {
        return super.getHeaders() + ",protectionLevel";
    }

    @Override
    public final String toCSV() {
        return super.toCSV() + "," + protectionLevel;
    }


    @Override
    public final String toString() {
        return super.toString() + " "
                + "ProtectionLevel=" + protectionLevel;
    }
}
