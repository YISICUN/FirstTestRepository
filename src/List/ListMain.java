package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListMain {
    public static void main(String[] args) {
        System.out.println("______________________________练习 1：基本操作（List）star__________________________________");
        // 1. 创建一个 ArrayList，存储字符串
        List<String> fruits = new ArrayList<String>();

        // 2. 添加元素
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Painaple");

        // 3. 遍历并打印所有水果名称
        System.out.println("List<String> fruits = new ArrayList<String>(); = " + fruits);
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println("________________________________________________________________");

        fruits.forEach(fruit -> {
            System.out.println(fruit);
        });
        System.out.println("________________________________________________________________");

        // 4. 修改第2个元素为 "Blueberry"
        fruits.set(1, "Blueberry");

        // 5. 删除元素 "Orange"
        fruits.remove(2);
        fruits.remove("Painaple");

        System.out.println("修改后列表：");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        System.out.println("________________________________________________________________");

        System.out.println("______________________________练习 2：Set 去重和排序star__________________________________");
        Set<Number> numbers = new HashSet<Number>();
        numbers.add(5);
        numbers.add(2);
        System.out.println("Set<Number> numbers = new HashSet<Number>(); = " + numbers);
        numbers.add(7);
        numbers.add(5);// 重复元素，不会被添加
        numbers.remove(2);
        System.out.println("HashSet（自动排序）： " + numbers);

        System.out.println("________________________________________________________________");

        System.out.println("______________________________练习 3：Map 基础操作__________________________________");

        // Map<> score = new HashMap<String, Integer>();
        // score.put(123, "wrong");
        // score.put("Hello", true);

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Hello", 123);
        // 添加键值对
        scores.put("Alice", 85);
        scores.put("Bob", 90);
        scores.put("Charlie", 78);
        System.out.println("Map<String, Integer> scores = new HashMap<>(); = " + scores);
        System.out.println("scores.entrySet(); = " + scores.entrySet());
        System.out.println("scores.keySet() = " + scores.keySet());
        System.out.println("scores.values() = " + scores.values());
        // 访问某个键的值
        System.out.println("Bob的分数是: " + scores.get("Bob"));
        System.out.println(scores.get("Charlie"));

        // 遍历所有键值对
        System.out.println("________________________________________________________________");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("________________________________________________________________");

        scores.entrySet().forEach(entry -> System.out.println(entry));

        System.out.println("______________________________练习 4：集合综合应用__________________________________");
        String[] words = { "apple", "banana", "apple", "orange", "banana", "apple" };
        System.out.println(words);
        // System.out.println(words[0]);
        System.out.println(Arrays.toString(words));
        // System.out.println(String.join(", ", words));
        // System.out.println("________________________________________________________________");

        // String[] words2 = new String[] { "" };
        // words2[0] = "test";
        // System.out.println(words2);
        // System.out.println(words2[0]);
        // System.out.println(Arrays.toString(words2));
        // System.out.println("________________________________________________________________");

        // int[] intArray = { 1, 2 };
        // System.out.println(intArray);
        // System.out.println(intArray[0]);
        // System.out.println(Arrays.toString(intArray));
        // Arrays.stream(intArray).forEach(System.out::println);
        // System.out.println("Arrays.stream(intArray) = " + Arrays.stream(intArray));
        // System.out.println("________________________________________________________________");

        Map<String, Integer> wordCount = new HashMap<>();
        // int count = 0;
        for (String word : words) {
            System.out.println(word);
            // System.out.println(wordCount.containsKey(word));
            // count = 1;
            // if (wordCount.containsKey(word)) {
            // count = wordCount.get(word) + 1;
            // }
            // System.out.println(word + " = " + count);
            // wordCount.put(word, count);

            System.out.println(wordCount.getOrDefault(word, 0));
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            System.out.println("________________________________________________________________");

        }
        System.out.println("wordCount = " + wordCount);
        System.out.println("wordCount.entrySet() = " + wordCount.entrySet());
        wordCount.entrySet().forEach(wordCountA -> {
            System.out.println(wordCountA.getKey() + "的个数 = " + wordCountA.getValue());
        });
        System.out.println("________________________________________________________________");

    }
}
