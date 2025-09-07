package List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) {
        System.out.println(
                "______________________________实现一个学生类，使用 List 存储学生对象，按分数排序__________________________________");
        List<Student> students = new ArrayList<>();
        students.add(new Student("张三", 18, 88.5));
        students.add(new Student("李四", 19, 92.0));
        students.add(new Student("王五", 17, 75.0));
        System.out.println(students);
        students.forEach(System.out::println);
        System.out.println("________________________________________________________________");

        Collections.sort(students);
        System.out.println("public class Student implements Comparable {");
        System.out.println("    public int compareTo(Object o) {\r\n" + //
                "        return -(this.getAge() - ((Student) o).getAge());");
        System.out.println("Collections.sort(students);");
        students.forEach(System.out::println);
        System.out.println("________________________________________________________________");

        students.sort(Comparator.comparingDouble(Student::getScore));
        System.out.println("students.sort(Comparator.comparingDouble(Student::getScore));");
        System.out.println("按分数升序排序：");
        students.forEach(System.out::println);
        System.out.println("________________________________________________________________");

        // 按分数降序排序（从高到低）
        students.sort(Comparator.comparingDouble(Student::getScore).reversed());
        System.out.println("students.sort(Comparator.comparingDouble(Student::getScore).reversed());");
        System.out.println("按分数降序排序：");
        students.forEach(System.out::println);
        System.out.println("________________________________________________________________");

        students.sort(Comparator.comparingInt(student -> ((Student) student).getAge()).reversed());
        System.out.println("按年龄降序排序：");
        students.forEach(System.out::println);
        System.out.println("________________________________________________________________");

        java.util.Iterator<Student> iterater = students.iterator();
        while (iterater.hasNext()) {
            System.out.println("iterater.next() = " + iterater.next());
        }
        System.out.println("________________________________________________________________");

        for (Student student : students) {
            System.out.println("student = " + student);
        }

        System.out.println("________________________________________________________________");

    }
}
