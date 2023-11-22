package backend;

import entity.Book;
import entity.Document;
import entity.Megazine;
import entity.Newspapers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocumentManagement {
    // Attribute
    List<Document> listDocument;
    Scanner scanner;

    public DocumentManagement() {
        this.listDocument = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method:
    // 1) Them tai lieu
    // 2) Xoa tai lieu
    // 3) In danh sach tai lieu
    // 4) Tim kiem
    public void runDocumentManagement(){
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addDocument();
                    break;
                case 2:
                    removeDocument();
                    break;
                case 3:
                    printListDocument();
                    break;
                case 4:
                    findDocument();
                    break;
                case 5:
                    System.out.println("Exit ! Bye bye");
                    return;
                default:
                    System.out.println("Vui long lua chon lai chuc nang cho dung !");
            }
        }
    }

    private void findDocument() {
        scanner.nextLine();
        System.out.println("Nhap ma tai lieu muon tim kiem : ");
        String inpDocumentCode = scanner.nextLine();
        Document document = listDocument.stream().filter(e -> e.getDocumentCode().equals(inpDocumentCode)).findFirst().orElse(null);
        if (document != null){
            System.out.println("## Ket qua tim kiem :");
            System.out.println(document);
        } else {
            System.out.println("Khong ton tai ma tai lieu vua nhap !");
        }

        System.out.println();
    }

    private void printListDocument() {
        System.out.println("### Danh sach tai lieu ###");
        if(listDocument.size() == 0){
            System.out.println("No Elements !!!");
        } else {
            for (Document d : listDocument){
                System.out.println(d);
            }
        }
        System.out.println("_______________________\n");
    }

    private void removeDocument() {
        scanner.nextLine();
        System.out.println("Nhap ma tai lieu muon xoa: ");
        String inpDocumentCode = scanner.nextLine();
        boolean check = listDocument.removeIf(element -> element.getDocumentCode().equals(inpDocumentCode));
        if (!check){
            System.out.println("Khong co tai lieu voi ma ban vua nhap de xoa\n");
        } else {
            System.out.println("Xoa thanh cong\n");
        }
    }

    // Ham de add tai lieu vao
    private void addDocument() {
        System.out.println("Lua chon loai tai lieu muon them vao");
        System.out.println("1 - Sach\t|\t2 - Tap chi\t|\t3 - Bao");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                addBook();
                break;
            case 2:
                addMegazine();
                break;
            case 3:
                addNewspapers();
                break;
            default:
                System.out.println("Nhap sai loai tai lieu !!!");
        }
    }

    private void addNewspapers() {
        String[] listBase = addBaseDocument();
        System.out.println("Nhap ngay phat hanh: ");
        String inpDayPublic = scanner.nextLine();

        Newspapers news = new Newspapers(listBase[0], listBase[1], Integer.parseInt(listBase[2]), inpDayPublic);
        listDocument.add(news);
        System.out.println("Them bao thanh cong\n");
    }

    private void addMegazine() {
        String[] listBase = addBaseDocument();
        System.out.println("Nhap so phat hanh: ");
        String inpNumberPublic = scanner.nextLine();
        System.out.println("Nhap thang phat hanh: ");
        String inpMonthPublic = scanner.nextLine();

        Megazine megazine = new Megazine(listBase[0], listBase[1], Integer.parseInt(listBase[2]), inpNumberPublic, inpMonthPublic);
        listDocument.add(megazine);
        System.out.println("Them tap chi thanh cong\n");
    }

    // Ham de add Book
    private void addBook() {
        String[] listBase = addBaseDocument();
        System.out.println("Nhap ten tac gia: ");
        String inpAuthor = scanner.nextLine();
        System.out.println("Nhap so trang sach: ");
        int inpTotalPage = scanner.nextInt();

        Book book = new Book(listBase[0], listBase[1], Integer.parseInt(listBase[2]), inpAuthor, inpTotalPage);
        listDocument.add(book);
        System.out.println("Them sach thanh cong\n");
    }

    private String[] addBaseDocument(){
        scanner.nextLine();
        System.out.println("Nhap ma tai lieu: ");
        String inpDocumentCode = scanner.nextLine();
        System.out.println("Ten nha xuat ban: ");
        String inpPublisher = scanner.nextLine();
        System.out.println("So luong phat hanh: ");
        int inpTotalRecords = scanner.nextInt();
        scanner.nextLine();
        return new String[]{inpDocumentCode, inpPublisher, String.valueOf(inpTotalRecords)};
    }

    private void printMenu(){
        System.out.println("*** Danh sach chuc nang ***");
        System.out.println("1 - Them moi tai lieu");
        System.out.println("2 - Xoa tai lieu ");
        System.out.println("3 - Hien thi danh sach tai lieu");
        System.out.println("4 - Tim kiem tai lieu");
        System.out.println("5 - Thoat chuong trinh");
        System.out.println("*** ------------------ ***\n");
    }

}
