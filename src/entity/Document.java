package entity;

public abstract class Document {
    private String documentCode;
    private String publisher;
    private int totalRecords;

    public String getDocumentCode() {
        return documentCode;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public Document(String documentCode, String publisher, int totalRecords) {
        this.documentCode = documentCode;
        this.publisher = publisher;
        this.totalRecords = totalRecords;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentCode='" + documentCode + '\'' +
                ", publisher='" + publisher + '\'' +
                ", totalRecords=" + totalRecords +
                '}';
    }
}
