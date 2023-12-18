package book;

public class FictionBook extends Book{
    private String category;



    public FictionBook(long bookcode, String name, int price, String author) {
        super(bookcode, name, price, author);
    }

    public FictionBook(long bookcode, String name, int price, String author, String category) {
        super(bookcode, name, price, author);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void displayBook() {
        super.displayBook();
        System.out.println("Loại sách này là" + category);
    }
}
