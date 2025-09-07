package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println("________________________________________________________________");

        List<String> fruits = new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        System.out.println("List<String> fruits = new ArrayList<String>();\n" + fruits);
        System.out.println("________________________________________________________________");

        Set<String> set = new HashSet<>();
        set.add(null);
        set.add("set");
        System.out.println("Set<String> set = new HashSet<>();\n" + set);
        System.out.println("________________________________________________________________");

        Map<String, Double> map = new HashMap<>();
        map.put("key", 1.1);
        map.put("key2", 1.12);
        System.out.println("Map<String, Double> map = new HashMap<>();\n" + map);
        System.out.println("map.entrySet() = \n" + map.entrySet());
        System.out.println("________________________________________________________________");

        int[] arrayInt = new int[10];
        arrayInt[0] = 0;
        arrayInt[6] = 6;
        System.out.println("int[] arrayInt = new int[10];\n" + arrayInt);
        System.out.println("Arrays.toString(arrayInt) = \n" + Arrays.toString(arrayInt));
        System.out.println("________________________________________________________________");

        String[] arrayString = new String[10];
        arrayString[0] = "0";
        arrayString[6] = "6";
        System.out.println("String[] arrayString = new String[10];\n" + arrayString);
        System.out.println("Arrays.toString(arrayString) = \n" + Arrays.toString(arrayString));
        System.out.println("________________________________________________________________");

        for (String string : arrayString) {
            System.out.println(string);
        }
        System.out.println("________________________________________________________________");

        String[][] deepStrings = new String[4][];
        deepStrings[0] = arrayString;
        deepStrings[1] = arrayString;
        System.out.println(Arrays.deepToString(deepStrings));
        System.out.println("________________________________________________________________");

    };
}
