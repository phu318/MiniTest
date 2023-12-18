package book;

public abstract class Book {
    private long bookcode;
    private String name;
    private int price;
    private String author;

    public Book() {
    }

    public Book(long bookcode, String name, int price, String author) {
        this.bookcode = bookcode;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public long getBookcode() {
        return bookcode;
    }

    public void setBookcode(long bookcode) {
        this.bookcode = bookcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
public  void displayBook(){
    System.out.println("Code của sách là " + bookcode);
    System.out.println("Tên sách là " + name);
    System.out.println("Giá sách là " + price);
    System.out.println("Tác giả " + author);
}
}
