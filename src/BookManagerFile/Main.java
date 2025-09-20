package BookManagerFile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("feature/NAP25OCT");
        String currentPath = System.getProperty("user.dir");
        System.out.println("当前路径：" + currentPath);
        Scanner sc = new Scanner(System.in);
        BookManager manager = new BookManager();

        while (true) {
            System.out.println("\n====== 图书管理系统 ======");
            System.out.println("1. 添加图书");
            System.out.println("2. 查看所有图书");
            System.out.println("3. 查找图书（按书名）");
            System.out.println("4. 退出并保存");
            System.out.print("请选择操作 (1-4): ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("请输入书名: ");
                    String title = sc.nextLine();
                    System.out.print("请输入作者: ");
                    String author = sc.nextLine();
                    System.out.print("请输入ISBN: ");
                    String isbn = sc.nextLine();
                    manager.addBook(new Book(title, author, isbn));
                    System.out.println("图书添加成功！");
                    break;

                case "2":
                    manager.showAllBooks();
                    break;

                case "3":
                    System.out.print("请输入要查找的书名: ");
                    String searchTitle = sc.nextLine();
                    manager.findBookByTitle(searchTitle);
                    break;

                case "4":
                    manager.saveToFile();
                    System.out.println("已保存，程序退出。");
                    sc.close();
                    return;

                default:
                    System.out.println("无效的选项，请重新输入。");
            }
        }
    }
}
