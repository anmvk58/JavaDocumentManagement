package entity;

public class Book extends Document{
    private String author;
    private int totalPage;

    public Book(String documentCode, String publisher, int totalRecords, String author, int totalPage) {
        super(documentCode, publisher, totalRecords);
        this.author = author;
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", totalPage=" + totalPage +
                "} " + super.toString();
    }
}
