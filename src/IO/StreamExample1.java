package IO;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExample1 {
    public static void main(String[] args) {
        System.out.println("________________________________________________________________");

        System.out.println("✅ 第一步：准备基础数据");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");
        System.out.println(names);
        System.out.println("________________________________________________________________");

        System.out.println("✅ 第二步：用 Stream 遍历并打印每个元素（forEach）");
        names.stream().forEach(name -> System.out.println(name));
        System.out.println("________________________________________________________________");

        System.out.println("✅ 第三步：过滤数据（filter）");
        names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);
        System.out.println("________________________________________________________________");

        System.out.println("✅ 第四步：转换数据（map）");
        names.stream().map(name -> name.toUpperCase()).forEach(System.out::println);
        System.out.println("________________________________________________________________");

        System.out.println("✅ 第五步：组合多个操作（链式编程）");
        names.stream()
                .filter(name -> name.length() > 3)
                .map(String::toUpperCase)
                .sorted((s1, s2) -> s2.compareTo(s1)) // 倒序
                .forEach(System.out::println);
        System.out.println("________________________________________________________________");

        System.out.println("✅ 第六步：使用 collect() 把结果保存");
        List<String> longNames = names.stream()
                .filter(name -> name.length() > 3)
                .sorted((s2, s1) -> s2.compareTo(s1))
                .collect(Collectors.toList());
        System.out.println(longNames);

        Map<String, Integer> map;
        map = longNames.stream().collect(Collectors.toMap(str -> str, String::length));
        System.out.println(map);
        map = longNames.stream().collect(Collectors.toMap(str -> str, str -> str.length()));
        System.out.println(map);
        longNames.stream().sorted();
        Map<Integer, String> map2;
        map2 = longNames.stream().collect(Collectors.toMap(String::length, str -> str, String::concat));
        System.out.println(map2);

        Map<String, Long> countMap = longNames.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("这句代码统计每个字符串出现的次数，简单且线程安全。" + countMap);

        String string = longNames.stream().collect(Collectors.joining(", "));
        System.out.println(string);
        System.out.println("________________________________________________________________");

        System.out.println("✅ 第七步：使用 reduce() 聚合操作（进阶）");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b); // 初始值为0

        System.out.println("reduce 是做归约操作，把流的元素合成一个值。总和是：" + sum);
        System.out.println("________________________________________________________________");

        System.out.println("________________________________________________________________");

    }
}
