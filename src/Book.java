import java.util.List;

public class Book {

    private String name;

    private String title;

    public Book(String name) {
        this.name = name;
    }

    public static Book[] getBookList() {
        return new Book[]{new Book("Book1"), new Book("Book2")};
    }

    public static Book getBook() {
        return new Book("Book3");
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return List.of("author");
    }
}
