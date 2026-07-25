
class Employee {

    private int id;
    private String name;
    private double salary;
    private String department;

    private Employee(EmployeeBuilder builder) {

        this.id = builder.id;
        this.name = builder.name;
        this.salary = builder.salary;
        this.department = builder.department;
    }

    static class EmployeeBuilder {

        private int id;
        private String name;
        private double salary;
        private String department;

        public EmployeeBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}

public class Builder {
    public static void main(String args[]) {
        Employee emp = new Employee.EmployeeBuilder()
                        .setId(101)
                        .setName("John")
                        .setSalary(50000)
                        .setDepartment("IT")
                        .build();
    }
}