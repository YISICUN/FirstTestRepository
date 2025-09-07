package Exception;

import java.util.Scanner;

public class MyExceptionMain {
    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("买酒年龄确认,请输入年龄:");
                Scanner scanner = new Scanner(System.in);
                String integerString = scanner.nextLine();
                if (integerString.matches("-?\\d+(\\.\\d+)?")) {
                    checkAge(Integer.parseInt(integerString));
                    break;
                } else {
                    System.out.println("这不是数字");
                }
            }

        } catch (MyException e) {
            System.out.println("发生异常：" + e.getMessage());
        }
    }

    public static void checkAge(int age) throws MyException {
        if (age < 18) {
            throw new MyException("年龄不能小于18");
        }
        System.out.println("年龄合法");
    }
}
