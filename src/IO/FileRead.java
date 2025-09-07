package IO;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileRead {
    public static void main(String[] args) throws IOException {

        System.out.println("当前工作目录：" + new File("").getAbsolutePath());
        System.out.println("________________________________________________________________");

        // File file = new
        // File("D:\\software_learning\\IDE_workspace\\MyJavaAppCreate\\src\\file\\data.txt");
        File file = new File("MyJavaAppCreate/src/file/data.txt");

        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();

        System.out.println("________________________________________________________________");

        System.out.println("| 类名                   | 作用                 | 备注                      |\r\n" + //
                "| -------------------- | ------------------ | ----------------------- |\r\n" + //
                "| `FileInputStream`    | 读取文件的字节流           | 适合读二进制文件                |\r\n" + //
                "| `FileOutputStream`   | 写文件的字节流            |                         |\r\n" + //
                "| `FileReader`         | 读取文件的字符流           | 适合读文本文件                 |\r\n" + //
                "| `FileWriter`         | 写文件的字符流            |                         |\r\n" + //
                "| `BufferedReader`     | 缓冲字符输入流，能按行读取文本    | 通常包装在 `FileReader` 外面使用 |\r\n" + //
                "| `BufferedWriter`     | 缓冲字符输出流            |                         |\r\n" + //
                "| `PrintWriter`        | 打印格式化文本            | 支持自动换行                  |\r\n" + //
                "| `DataInputStream`    | 读取 Java 原生数据类型的字节流 | 如 `int`, `double` 等     |\r\n" + //
                "| `DataOutputStream`   | 写 Java 原生数据类型      |                         |\r\n" + //
                "| `ObjectInputStream`  | 读取对象序列化数据          | 用于对象的序列化与反序列化           |\r\n" + //
                "| `ObjectOutputStream` | 写对象序列化数据           |                         |\r\n" + //
                "");
        System.out.println("________________________________________________________________");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("当 readLine() 返回 null，表示文件已经读到末尾。");
        bufferedReader.close();
        System.out.println("________________________________________________________________");

        FileReader fileReader2 = new FileReader(file);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        while (bufferedReader2.ready()) {
            System.out.println(bufferedReader2.readLine());
        }
        System.out.println("ready() 有时会返回 false，但文件还没读完（比如网络流），所以不建议用它判断文件结尾。\n" + //
                "ready() 适合用来判断流是否阻塞等待数据，不适合判断读完。");

        System.out.println("________________________________________________________________");

        FileReader fileReader3 = new FileReader(file);
        BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
        int ch;
        while ((ch = bufferedReader3.read()) != -1) {
            System.out.print((char) ch);
        }
        System.out.println("BufferedReader 的 read() 方法返回字符的整数值，读取到末尾返回 -1。");

        System.out.println("________________________________________________________________");

        System.out.println("1. 什么是 BufferedInputStream\n" + //
                "\n" + //
                "它是 InputStream 的子类。\n" + //
                "\n" + //
                "包装其他输入流，如 FileInputStream。\n" + //
                "\n" + //
                "通过缓冲来提高读取性能。\n" + //
                "\n" + //
                "适合读取二进制数据（图片、视频、音频等）。\n" + //
                "\n" + //
                " 2. 使用场景\n" + //
                "\n" + //
                "想从文件、网络或其他地方读取大量字节数据。\n" + //
                "\n" + //
                "希望读取更高效，避免频繁访问硬盘。\n" + //
                "\n" + //
                "通常与 FileInputStream 一起使用。");
        System.out.println("________________________________________________________________");

        FileInputStream streamFile = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(streamFile);
        int ch2;
        while ((ch2 = bufferedInputStream.read()) != -1) {
            System.out.print((char) ch2);
        }
        bufferedInputStream.close();
        System.out.println("BufferedInputStream 是 Java IO 中的一个重要类，用于提高读取字节数据的效率，通过在内存中使用缓冲区减少实际读磁盘的次数。");
        System.out.println("________________________________________________________________");

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            int byteData;
            while ((byteData = bis.read()) != -1) {
                System.out.print((char) byteData); // 示例：将字节转为字符打印
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("try catch 版本");
        System.out.println("________________________________________________________________");

        System.out.println("6. 读取字节数组的方式（更高效）");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[1024];
        int length;
        while ((length = bis.read(buffer)) != -1) {
            // 可以写入到另一个文件、处理数据等
            System.out.write(buffer, 0, length);
        }
        System.out.println("________________________________________________________________");

    }
}
