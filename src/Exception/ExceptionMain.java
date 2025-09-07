package Exception;

import java.io.File;
import java.io.FileReader;

public class ExceptionMain {
    public static void main(String[] args) throws Exception {
        System.out.println("________________________________________________________________");

        try {
            File file = new File("MyJavaAppCreate/src/file/data.txt");
            FileReader fileReader = new FileReader(file);
            while (fileReader.ready()) {
                int intChar = fileReader.read();
                System.out.println("char=\"" + (char) intChar + "\";   int=\"" + intChar + "\";");
                // throw new ArrayIndexOutOfBoundsException("数组索引超出范围异常");
            }
            fileReader.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("catch ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("_________________________________异常抛出_______________________________");
            System.out.println("e.printStackTrace():");
            e.printStackTrace();
            System.out.println("________________________________________________________________");

            System.out.println("捕获到异常：" + e.getMessage());
            System.out.println("________________________________________________________________");

            System.out.println("遍历e.getStackTrace():");
            for (StackTraceElement element : e.getStackTrace()) {
                System.out.println(element.toString());
            }
            System.out.println("________________________________________________________________");

            System.out.println("或者更简洁一点：");
            // System.out.println("Arrays.toString(e.getStackTrace()) = " +
            // Arrays.toString(e.getStackTrace()));
            // System.out.println("Arrays.stream(e.getStackTrace()) = " +
            // Arrays.stream(e.getStackTrace()));
            // Arrays.stream(e.getStackTrace()).forEach(System.out::println);
            System.out.println("Arrays.stream(e.getStackTrace()).forEach(System.out::println);");
            System.out.println("________________________________________________________________");

            throw e;
        } finally {
            System.out.println("读取文件程序结束");
            System.out.println("________________________________________________________________");

        }
        System.out.println("________________________________________________________________");

    }
}
