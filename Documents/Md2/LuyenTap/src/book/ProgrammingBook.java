package book;

public class ProgrammingBook extends Book{

private String language;
private String framework;

    public ProgrammingBook(long bookcode, String name, int price, String author) {
        super(bookcode, name, price, author);
    }

    public ProgrammingBook(long bookcode, String name, int price, String author, String language, String framework) {
        super(bookcode, name, price, author);
        this.language = language;
        this.framework = framework;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    @Override
    public void displayBook() {
        super.displayBook();
        System.out.println("Ngôn ngữ là " + language);
        System.out.println("Framwork là " + framework);
    }
}
