import book.Book;
import book.FictionBook;
import book.ProgrammingBook;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[10];
        books[0] = new ProgrammingBook(1, "Code dạo kí sự – Lập trình viên đâu phải chỉ biết code. ...",100,"Quốc Phú","Java","pppp");
        books[1] = new ProgrammingBook(2, "Code dạo kí sự – Lập trình viên đâu phải chỉ biết code. ...",200,"Quốc Phú","Python","kkk");
        books[2] = new ProgrammingBook(3, "Code dạo kí sự – Lập trình viên đâu phải chỉ biết code. ...",200,"Quốc Phú","Java","aaa");
        books[3] = new ProgrammingBook(4, "Code dạo kí sự – Lập trình viên đâu phải chỉ biết code. ...",2000,"Quốc Phú","PHP","nnnn");
        books[4] = new ProgrammingBook(5, "Code dạo kí sự – Lập trình viên đâu phải chỉ biết code. ...",20,"Quốc Phú","Java","bbbb");
        books[5] = new FictionBook(6,"ppppp",20,"kkkk","hohohoh");
        books[6] = new FictionBook(7,"ppppp",120,"kkkk","hohohoh");
        books[7] = new FictionBook(8,"ppppp",103,"kkkk","Vien tuong");
        books[8] = new FictionBook(9,"ppppp",19,"kkkk","hohohoh");
        books[9] = new FictionBook(10,"ppppp",13,"kkkk","Vien tuong");
        displayBook1(books);
        int totalBook = totalBook(books);
        System.out.println("Tổng tiền là " + totalBook);
        int countBookByPrice = countBookByPrice(books);
        System.out.println("Số lượng sách có giá bé hơn 100 " + countBookByPrice);
        int countBook = countBook(books);
        System.out.println("Số sách có ngôn ngữ Java ProgramingBook " + countBook);
        int countBookFiction = countBookFiction(books);
        System.out.println("Số sách loại vien tuong trong FictionBook " + countBookFiction);

    }

    private static void displayBook() {
    }

    public static int totalBook(Book[] books) {
        int total = 0;
        for (Book book :books) {
        total += book.getPrice();
        }
        return total;
    }
    public static void displayBook1(Book[] books){
        for (Book book:books) {
            if (books!= null){
                book.displayBook();
                System.out.println();
            }

        }
    }
    public static int countBook(Book[] books){
        int count = 0;
        for (Book book:books) {
            if (book instanceof ProgrammingBook ){//ép kiểu ve Programing book
                ProgrammingBook programmingBook = (ProgrammingBook) book;
                if ("Java" == programmingBook.getLanguage()){// lấy ngôn ngữ từ lớp programing book nếu bằng chuỗi java thì count ++
                    count++;
                }
            }
        }
        return count;
    }
    public static int countBookFiction(Book[] books){
        int count = 0 ;
        for (Book book:books) {
            if (book instanceof FictionBook){
                FictionBook fictionBook = (FictionBook) book;
                if ("Vien tuong" == fictionBook.getCategory()){
                    count++;
                }
            }
        }
        return count;
    }
    public static int countBookByPrice(Book[] books){
        int count = 0;
        for (int i = 0; i < books.length; i++)
            if (books[i] instanceof FictionBook && ((FictionBook) books[i]).getPrice() <100) {
count++;
            }
        return count;
    }

}