package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListUtilsMain {
    public static void main(String[] args) {
        System.out.println("________________________________________________________________");

        List<String> listA = Arrays.asList("apple", "banana", "cherry", "date");
        List<String> listB = Arrays.asList("banana", "date", "fig", "grape");

        List<String> result = getIntersection(listA, listB);

        System.out.println("交集结果：");
        result.forEach(System.out::println);

        System.out.println("________________________________________________________________");

    }

    public static <T> List<T> getIntersection(List<T> list1, List<T> list2) {
        Set<T> set1 = new HashSet<>(list1); // 去重并快速查找
        Set<T> intersection = new HashSet<>();
        System.out.println("________________________________________________________________");

        for (T item : list2) {
            if (set1.contains(item)) {
                intersection.add(item); // 添加交集元素
            }
        }

        System.out.println("________________________________________________________________");
        return new ArrayList<>(intersection); // 返回 List 类型

    }
}
