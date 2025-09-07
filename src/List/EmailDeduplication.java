package List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EmailDeduplication {
    public static void main(String[] args) {
        System.out.println(
                "______________________________使用 HashSet 实现一个简单的去重功能，比如用户输入的邮箱去重__________________________________");
        Scanner scanner = new Scanner(System.in);
        Set<String> emailSet = new HashSet<>();

        System.out.println("请输入邮箱（输入 empty 或回车结束）：");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty() || input.equalsIgnoreCase("empty")) {
                break;
            }

            if (emailSet.add(input)) {
                System.out.println("添加成功：" + input);
            } else {
                System.out.println("重复邮箱，已忽略：" + input);
            }
        }

        System.out.println("\n去重后的邮箱列表：");
        emailSet.forEach(System.out::println);

        // 转换为 List 进行排序
        List<String> sortedList = new ArrayList<>(emailSet);
        Collections.sort(sortedList);

        System.out.println("排序后：");
        for (String item : sortedList) {
            System.out.println(item);
        }

        scanner.close();
        System.out.println("________________________________________________________________");

    }
}
