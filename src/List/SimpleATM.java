package List;

import java.util.Scanner;

public class SimpleATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 1000.0; // 初始余额

        while (true) {
            System.out.println("\n=== 欢迎使用简易ATM系统 ===");
            System.out.println("1. 查看余额");
            System.out.println("2. 存钱");
            System.out.println("3. 取钱");
            System.out.println("4. 退出");
            System.out.print("请输入你的选择（1-4）：");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                // scanner.nextLine();
            } else {
                System.out.println("❌ 输入无效，请输入数字。");
                scanner.next(); // 清除错误输入
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("💰 当前余额为: ￥" + balance);
                    break;
                case 2:
                    System.out.print("请输入要存入的金额：");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("✅ 存款成功，新余额为: ￥" + balance);
                    } else {
                        System.out.println("❌ 金额必须大于0。");
                    }
                    break;
                case 3:
                    System.out.print("请输入要取出的金额：");
                    double withdraw = scanner.nextDouble();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("✅ 取款成功，新余额为: ￥" + balance);
                    } else {
                        System.out.println("❌ 金额无效或余额不足。");
                    }
                    break;
                case 4:
                    System.out.println("👋 感谢使用，再见！");
                    scanner.close();
                    return; // 结束程序
                default:
                    System.out.println("❌ 无效的选项，请重新选择。");
            }
        }
    }
}
