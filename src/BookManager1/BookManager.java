package BookManager1;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
    private ArrayList<Book> bookList;
    private Scanner scanner;

    public BookManager() {
        bookList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("欢迎使用图书管理系统！");
        boolean running = true;

        while (running) {
            System.out.println("\n请选择操作：");
            System.out.println("1. 添加图书");
            System.out.println("2. 查看图书列表");
            System.out.println("3. 删除图书");
            System.out.println("4. 退出系统");
            System.out.print("请输入选项（1-4）：");

            int choice = readInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    showBooks();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    running = false;
                    System.out.println("谢谢使用，再见！");
                    break;
                default:
                    System.out.println("无效的选项，请重新输入！");
            }
        }

        scanner.close();
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("请输入数字：");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine(); // 清除换行符
        return num;
    }

    private void addBook() {
        System.out.print("请输入书名：");
        String title = scanner.nextLine();
        System.out.print("请输入作者：");
        String author = scanner.nextLine();
        System.out.print("请输入ISBN：");
        String isbn = scanner.nextLine();

        bookList.add(new Book(title, author, isbn));
        System.out.println("图书添加成功！");
    }

    private void showBooks() {
        if (bookList.isEmpty()) {
            System.out.println("图书列表为空！");
            return;
        }
        System.out.println("当前图书列表：");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println((i + 1) + ". " + bookList.get(i));
        }
    }

    private void removeBook() {
        if (bookList.isEmpty()) {
            System.out.println("图书列表为空，无法删除！");
            return;
        }
        System.out.print("请输入要删除的图书编号：");
        int index = readInt() - 1;
        if (index >= 0 && index < bookList.size()) {
            Book removed = bookList.remove(index);
            System.out.println("已删除：" + removed);
        } else {
            System.out.println("编号无效！");
        }
    }
}
