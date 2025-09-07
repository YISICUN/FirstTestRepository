package IO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingBy {
    public static void main(String[] args) {
        System.out.println("________________________________________________________________");

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 5000),
                new Employee("Bob", "IT", 7000),
                new Employee("Charlie", "HR", 5000),
                new Employee("David", "IT", 6000),
                new Employee("Eva", "Finance", 6500));

        Map<String, List<Employee>> groupByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("1. 按部门分组");
        groupByDept.forEach((dept, emps) -> {
            System.out.println(dept + ": " + emps);
        });
        System.out.println("________________________________________________________________");

        System.out.println("1.2. 按xinshui分组");
        employees.stream().collect(Collectors.groupingBy(Employee::getSalary))
                .forEach((dept, emps) -> System.out.println(dept + ": " + emps));
        System.out.println("________________________________________________________________");

        System.out.println("2. 按部门统计员工数量");
        Map<String, Long> groupByDept2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        groupByDept2.forEach((dept, count) -> System.out.println(dept + " 部门人数: " + count));
        System.out.println("________________________________________________________________");

        System.out.println("3. 按部门统计平均薪资");
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));
        avgSalaryByDept.forEach((dept, avg) -> {
            System.out.println(dept + " 部门平均薪资: " + avg);
        });
        System.out.println("________________________________________________________________");

        System.out.println("4. 按部门找薪资最高的员工");
        Map<String, Optional<Employee>> maxSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));

        maxSalaryByDept.forEach((dept, empOpt) -> {
            empOpt.ifPresent(emp -> System.out.println(dept + " 部门薪资最高: " + emp));
        });
        System.out.println("________________________________________________________________");

    }
}
