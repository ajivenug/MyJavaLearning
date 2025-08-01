
public class Employee {

    private String name;
    private int age;
    private double salary;
    private String department;

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + ", department='" + department + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return age == employee.age
                && Double.compare(employee.salary, salary) == 0
                && name.equals(employee.name)
                && department.equals(employee.department);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        long temp = Double.doubleToLongBits(salary);
        result = 31 * result + age;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
