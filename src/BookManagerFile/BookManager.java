package BookManagerFile;

import java.io.*;
import java.util.*;

public class BookManager {
    private List<Book> books = new ArrayList<>();
    private final String FILE_NAME = "MyJavaAppCreate\\src\\BookManagerFile\\books.txt";

    public BookManager() {
        loadFromFile();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("暂无图书记录。");
        } else {
            // for (Book b : books) {
            // System.out.println(b);
            // }
            books.forEach(System.out::println);
        }
    }

    public void findBookByTitle(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println("找到图书: " + b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("未找到名为 \"" + title + "\" 的图书。");
        }
    }

    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Book b : books) {
                pw.println(b.toFileString());
            }
        } catch (IOException e) {
            System.out.println("保存失败: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists())
            return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                Book book = Book.fromFileString(line);
                if (book != null) {
                    books.add(book);
                }
            }
        } catch (IOException e) {
            System.out.println("读取失败: " + e.getMessage());
        }
    }
}
