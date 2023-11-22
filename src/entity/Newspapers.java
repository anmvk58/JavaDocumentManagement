package entity;

public class Newspapers extends Document{
    private String dayPublic;

    public Newspapers(String documentCode, String publisher, int totalRecords, String dayPublic) {
        super(documentCode, publisher, totalRecords);
        this.dayPublic = dayPublic;
    }

    @Override
    public String toString() {
        return "Newspapers{" +
                "dayPublic='" + dayPublic + '\'' +
                "} " + super.toString();
    }
}
