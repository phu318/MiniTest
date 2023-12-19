import book.Book;
import book.FictionBook;
import book.ProgrammingBook;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();

        bookList.add(new ProgrammingBook(1, "Code dạo kí sự – Lập trình viên đâu phải chỉ biết code. ...", 100, "Anh", "Java", "pppp"));
        bookList.add(new ProgrammingBook(2, "Code dạo kí sự – Lập trình viên đâu phải chỉ biết code. ...", 200, "Quốc ", "Python", "kkk"));
        bookList.add(new ProgrammingBook(3, "Code dạo kí sự – Lập trình viên đâu phải chỉ biết code. ...", 200, "Quốc Phú", "Java", "aaa"));
        bookList.add(new ProgrammingBook(4, "Code dạo kí sự – Lập trình viên đâu phải chỉ biết code. ...", 2000, "Quốc Ca", "PHP", "nnnn"));
        bookList.add(new ProgrammingBook(5, "Code dạo kí sự – Lập trình viên đâu phải  ...", 20, "Quốc Phú", "Java", "bbbb"));
        bookList.add(new FictionBook(6, "ppppp", 20, "kkkk", "hohohoh"));
        bookList.add(new FictionBook(7, "ppppp", 120, "kkkk", "hohohoh"));
        bookList.add(new FictionBook(8, "ppppp", 103, "kkkk", "Vien tuong"));
        bookList.add(new FictionBook(9, "ppppp", 19, "kkkk", "hohohoh"));
        bookList.add(new FictionBook(10, "ppppp", 13, "kkkk", "Vien tuong"));

        //thêm sách
        //addBook(bookList);
        //xóa sách theo code
        //removeBookByCode(bookList,3);
        //tìm sách theo tên tác giả
        //findBookByAuthor(bookList,"Quốc ");
        // lấy size của danh sách sách
        //checkNumberOfBook(bookList);
        // Kiểm tra danh sách sách có rỗng không
        //checkIfListIsEmpty(bookList);
        //Sắp xếp theo giá tăng dần
        //sortByPrice(bookList);

        int choice;
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("MENU");
            System.out.println("1. Thêm sách");
            System.out.println("2. Xóa sách");
            System.out.println("3. Tìm kiếm sách");
            System.out.println("4. Kiểm tra số lượng sách");
            System.out.println("5. Kiểm tra sách còn không");
            System.out.println("6. Sắp xếp sách theo giá");
            System.out.println("7. Thoát");
//            choice = Integer.parseInt(scanner.nextLine());
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    addBook(bookList);
                    break;
                case 2:
                    removeBookByCode(bookList,3);
                    break;
                case 3:
                    findBookByAuthor(bookList,"Quốc ");
                    break;
                case 4 :
                    checkNumberOfBook(bookList);
                    break;
                case 5 :
                    checkIfListIsEmpty(bookList);
                    break;
                case 6:
                    sortByPrice(bookList);
                    break;
                case 7:
                    flag = true;
                    break;
                default:
                    System.out.println(" Sụ lựa chọn của bạn không hợp lệ");
            }
        }while (!flag);
    }





    public static int totalBook(List<Book> bookList) {
        int total = 0;
        for (Book book : bookList) {
            total += book.getPrice();
        }
        return total;
    }

    public static void displayBook1(List<Book> bookList) {
        for (Book book : bookList) {
//            if (bookList != null) {
//                book.displayBook();
//                System.out.println();
//            }
            System.out.println(book.toString());
        }
    }

    public static int countBook(List<Book> bookList) {
        int count = 0;
        for (Book book : bookList) {
            if (book instanceof ProgrammingBook) {//ép kiểu ve Programing book
                ProgrammingBook programmingBook = (ProgrammingBook) book;
                if ("Java" == programmingBook.getLanguage()) {// lấy ngôn ngữ từ lớp programing book nếu bằng chuỗi java thì count ++
                    count++;
                }
            }
        }
        return count;
    }

    public static int countBookFiction(List<Book> bookList) {
        int count = 0;
        for (Book book : bookList) {
            if (book instanceof FictionBook) {
                FictionBook fictionBook = (FictionBook) book;
                if ("Vien tuong" == fictionBook.getCategory()) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countBookByPrice(List<Book> bookList) {
        int count = 0;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i) instanceof FictionBook && ((FictionBook) bookList.get(i)).getPrice() < 100) {
                count++;
            }

        }
        return count;
    }
    public static void addBook(List<Book> bookList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn vui lòng nhập thông tin sách muốn thêm");
        System.out.println("Nhập mã code");
        long bookCode = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Nhập tên sách");
        String name = scanner.nextLine();
        System.out.println("Nhập giá");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tác giả");
        String author = scanner.nextLine();

        System.out.println("Nhập ngôn ngữ");
        String language = scanner.nextLine();

        System.out.println("Nhập framework");
        String framework = scanner.nextLine();
        Book book = new ProgrammingBook(bookCode,name,price,author,language,framework);
        bookList.add(book);
        displayBook1(bookList);
    }

    public static void removeBookByCode(List<Book> bookList, long bookcode) {
        for (Book book : bookList) {
            if (book.getBookcode() == 3) {
                bookList.remove(book);
                break;
            }
        }
        displayBook1(bookList);
    }

    public static void findBookByAuthor(List<Book> bookList, String author) {
        boolean containsBook = false;
        for (Book book : bookList) {
            if (book.getAuthor() == "Quốc ") {
                containsBook = true;
                System.out.println("Sách có tác giả là " + author + " tồn tại:\n" + book.toString());
                break;
            }
        }
        if (!containsBook) {
            System.out.println("Sách có tác giả là " + author + " không tồn tại.");
        }

    }

    public static void checkNumberOfBook(List<Book> bookList) {
        long numberOfBook = bookList.size();
        System.out.println("Số lượng sách là : " + numberOfBook);
    }

    public static void sortByPrice(List<Book> bookList) {
        Comparator<Book> priceComparator = Comparator.comparing(Book::getPrice);
        Collections.sort(bookList, priceComparator);
        displayBook1(bookList);
    }

    public static void checkIfListIsEmpty(List<Book> bookList) {
        boolean isListEmpty = bookList.isEmpty();
        if (bookList.isEmpty()){
            System.out.println("Danh sách là rỗng");
        }else {
            System.out.println("Danh sách không rỗng");
        }
    }


}