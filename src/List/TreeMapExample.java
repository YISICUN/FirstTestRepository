package List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        System.out.println("________________________________________________________________");

        TreeMap<String, Double> studentScores = new TreeMap<>();

        studentScores.put("Alice", 88.5);
        studentScores.put("Charlie", 75.0);
        studentScores.put("Bob", 92.0);

        System.out.println("按姓名升序排序后的学生成绩：");
        for (Map.Entry<String, Double> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        System.out.println("________________________________________________________________");

        System.out.println("studentScores = " + studentScores);
        System.out.println("studentScores.entrySet() = " + studentScores.entrySet());
        studentScores.forEach((key, value) -> {
            System.out.println("key: " + key + ", value: " + value);
        });
        System.out.println("________________________________________________________________");

        studentScores.entrySet().forEach(System.out::println);
        System.out.println("________________________________________________________________");

        // 按姓名降序排序
        System.out.println("按姓名降序排序后的学生成绩：");
        studentScores.reversed().forEach((name, score) -> System.out.println(name + " => " + score));
        System.out.println("________________________________________________________________");

        List<Map.Entry<String, Double>> list = new ArrayList<>(studentScores.entrySet());
        System.out.println(list);
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        System.out.println(list);
        list.sort(Comparator.comparingDouble(Map.Entry::getValue));
        list.sort(Comparator.comparingDouble(Map.Entry<String, Double>::getValue));
        list.sort(Comparator.comparingDouble(Map.Entry<String, Double>::getValue).reversed());
        System.out.println(list);
        System.out.println("按学生成绩降序排序后的学生成绩：");
        list.reversed().forEach(System.out::println);
        System.out.println("________________________________________________________________");

    }

}
