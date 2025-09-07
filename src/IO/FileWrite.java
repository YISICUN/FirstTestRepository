package IO;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
    public static void main(String[] args) throws IOException {

        System.out.println("当前工作目录：" + new File("").getAbsolutePath());
        System.out.println("________________________________________________________________");

        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(new File("MyJavaAppCreate/src/file/data.txt")))) {
            int byteData;
            while ((byteData = bis.read()) != -1) {
                System.out.print((char) byteData); // 示例：将字节转为字符打印
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件读取完成");
        System.out.println("________________________________________________________________");

        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(new File("MyJavaAppCreate/src/file/data.txt")))) {
            File fileOut = new File("MyJavaAppCreate/src/file/dataOut.txt");
            FileWriter fileWriter = new FileWriter(fileOut, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            int byteData;
            while ((byteData = bis.read()) != -1) {
                System.out.print((char) (byteData + 1) + " "); // 示例：将字节转为字符打印
                bufferedWriter.write(byteData + 1);
                // bufferedWriter.newLine();
            }
            bufferedWriter.newLine();
            bufferedWriter.close();
            System.out.println("文件写入完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("________________________________________________________________");

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(new File("MyJavaAppCreate/src/file/data.txt")))) {
            File fileOut = new File("MyJavaAppCreate/src/file/dataOut.txt");
            FileWriter fileWriter = new FileWriter(fileOut, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String record;
            while ((record = bufferedReader.readLine()) != null) {
                System.out.println(record);
                bufferedWriter.write("Out:");
                bufferedWriter.write(record);
                bufferedWriter.newLine();
            }
            System.out.println("文件写入完成");
            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println("________________________________________________________________");

    }
}
