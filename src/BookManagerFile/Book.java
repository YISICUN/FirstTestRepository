package BookManagerFile;

public class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String toFileString() {
        return title + "," + author + "," + isbn;
    }

    public static Book fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3)
            return null;
        return new Book(parts[0], parts[1], parts[2]);
    }

    @Override
    public String toString() {
        return "书名: " + title + ", 作者: " + author + ", ISBN: " + isbn;
    }

    public String getTitle() {
        return title;
    }
}
