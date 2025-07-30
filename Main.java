
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Create a list of Employee objects
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000, "HR"));
        employees.add(new Employee("Bob", 25, 60000, "IT"));
        employees.add(new Employee("Charlie", 30, 55000, "HR"));

        // Print employees with age 30
        employees.stream().filter(e -> e.getAge() == 30)
                .forEach(e -> System.out.println(e.getName() + " earns " + e.getSalary()));

        // Create a list of integers
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Print whether each number is even or odd
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                System.out.println("Even number: " + number);
            } else {
                System.out.println("Odd number: " + number);
            }
        }

        // Create a list of squares of the numbers
        List<Integer> squares = numbers.stream().map(e1 -> e1 * e1).collect(Collectors.toList());
        System.out.println("Squares of numbers: " + squares);

        // Print names of employees with salary greater than 50000
        employees.stream().filter(e -> e.getSalary() > 50000).map(Employee::getName)
                .forEach(name -> System.out.println("Employee name: " + name));

        // Group employees by age and print each group
        employees.stream().collect(Collectors.groupingBy(classifier -> classifier.getAge()))
                .forEach((age, empList) -> System.out.println("Age: " + age + ", Employees: " + empList));

        // Create a list of integers with some nulls
        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(123, 456, null, null, 156, 145, 897));

        // Filter numbers that are not null and start with '1'
        List<Integer> list2 = numbers2.stream()
                .filter(e -> e != null)
                .filter(e -> e.toString().startsWith("1"))
                .collect(Collectors.toList());
        System.out.println(list2);

        // Group employees by department and sum their salaries
        Map<String, Double> salaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)
                ));

        // Print total salary by department
        salaryByDepartment.forEach((department, totalSalary)
                -> System.out.println("Department: " + department + ", Total Salary: " + totalSalary));

        // Count employees by department
        Map<String, Long> empoloyeeCountByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        empoloyeeCountByDepartment.forEach((department, count)
                -> System.out.println("Department: " + department + ", Employee Count: " + count));

        // Create a list of strings
        List<String> inputList = Arrays.asList("abc", "axy", "add", "a", "ab");

        // Filter strings that start with 'a' and have length 3
        List<String> modifiedList = inputList.stream().filter(s -> s.startsWith("a") && s.length() == 3).collect(Collectors.toList());
        System.out.println("Modified List: " + modifiedList);

        // Flatten a list of lists
        List<List<String>> input = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D")
        );

        List<String> flatList = input.stream()
                .flatMap(mapper -> mapper.stream())
                .collect(Collectors.toList());
        System.out.println("Flat List: " + flatList);

        // Find the first non-repeating character in a string
        String inputStr = "swiss";
        String firstNonRepeatingChar = inputStr.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> inputStr.indexOf(c) == inputStr.lastIndexOf(c))
                .findFirst()
                .map(String::valueOf)
                .orElse(null);
        System.out.println("First non-repeating character: " + firstNonRepeatingChar);

        // Count occurrences of each word in a string
        String inputString = "Java is fun and Java is powerful";
        String[] words = inputString.split(" ");
        Map<String, Long> wordCount = Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        wordCount.forEach((word, count) -> System.out.println("Word: " + word + ", Count: " + count));

    }

}
