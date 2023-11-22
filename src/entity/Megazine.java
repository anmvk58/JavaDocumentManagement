package entity;

public class Megazine extends Document{
    private String numberPublic;
    private String monthPublic;

    public Megazine(String documentCode, String publisher, int totalRecords, String numberPublic, String monthPublic) {
        super(documentCode, publisher, totalRecords);
        this.numberPublic = numberPublic;
        this.monthPublic = monthPublic;
    }

    @Override
    public String toString() {
        return "Megazine{" +
                "numberPublic='" + numberPublic + '\'' +
                ", monthPublic='" + monthPublic + '\'' +
                "} " + super.toString();
    }
}
